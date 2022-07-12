package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.dto.request.CreateVacancyRequest;
import com.recruit.recruitms.dto.request.VacancyDto;
import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.entity.NotificationEmail;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.entity.Vacancy;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.VacancyRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IVacancyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class VacancyService implements ICrudService<Vacancy, Long>, IVacancyService {
    private final VacancyRepository repo;
    private final TagService _tagService;
    private final CountryService _countryService;
    private final OrganizationService _organizationService;

    private final ApplicationService _applicationService;
    private final MailService _mailService;


    @Override
    public Vacancy create(Vacancy vacancy) {
        return repo.save(vacancy);
    }

    @Override
    public List<Vacancy> createInBulk(List<Vacancy> vacancyList) {
        return repo.saveAll(vacancyList);
    }

    @Override
    public Vacancy createVacancyByRequest(CreateVacancyRequest request) {
        List<String> newTagString = request.getTags().stream().filter(tag -> ! _tagService.getAll().stream().map(Tag::getName).toList().contains(tag)).toList();

        List<Tag> newTagList = newTagString.stream().map(x-> new Tag(x, Enum.TagType.Vacancy,0L)).toList();
        _tagService.createInBulk(newTagList);

        List<Tag> selectedTags = request.getTags().stream().map(_tagService::getByName).toList();
        //Update TotalUsed of Tag
        selectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() + 1);
            _tagService.update(x);
        });

        Vacancy vacancy = new Vacancy(
                request.getName(),
                request.getDescription(),
                selectedTags,
                _countryService.getByIso(request.getCountryISO()),
                _organizationService.getById(request.getOrganizationId()),
                request.getNumberOfOpening(),
                request.getMinSalary(),
                request.getMaxSalary(),
                request.getRemarks(),
                request.getObjectState()
            );

        return this.create(vacancy);
    }

    @Override
    public List<Vacancy> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Vacancy> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    public Vacancy getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public Vacancy update(Vacancy vacancy){
        return repo.save(vacancy);
    }

    public Vacancy updateByRequest(VacancyDto vacancy){
        List<String> newTagString = vacancy.getTagString().stream().filter(tag -> ! _tagService.getAll().stream().map(Tag::getName).toList().contains(tag)).toList();
        List<Tag> newTagList = newTagString.stream().map(x-> new Tag(x, Enum.TagType.Vacancy,0L)).toList();
        _tagService.createInBulk(newTagList);

        //Update TotalUsed of Tag
        List<Tag> oldSelectedTags = vacancy.getTags();
        oldSelectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() - 1);
            _tagService.update(x);
        });

        List<Tag> selectedTags = vacancy.getTagString().stream().map(_tagService::getByName).toList();
        selectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() + 1);
            _tagService.update(x);
        });

        vacancy.setTags(selectedTags);
        return this.update(vacancy.mapToEntity());
    }

    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    public boolean terminate(Long id){
        Vacancy vacancy = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        vacancy.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(vacancy);

        for(Application application : _applicationService.getApplicationByVacancyId(id)){
            application.setStatus(Enum.ApplicationStatus.CANCEL);
            _applicationService.update(application);

            _mailService.sendMail(new NotificationEmail("The vacancy you applied have been terminated!",
                    application.getCandidate().getEmail(), application.getCandidate().getFullName(),
                    "Sorry! The vacancy you applied have been terminated! Therefore, your Application have been cancelled! Please contact with the employer to follow up.",
                    "Vacancy: "+ application.getVacancy().getName() + " from " + application.getVacancy().getOrganization().getName() +
                            "\n;Employer Email: "+ application.getVacancy().getOrganization().getOwner().getEmail()));

        }

        return true;
    }

    public boolean activate(Long id){
        Vacancy vacancy = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        vacancy.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(vacancy);
        return true;
    }
}
