package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.entity.NotificationEmail;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ApplicationRepository;
import com.recruit.recruitms.service.IApplicationService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService implements ICrudService<Application, Long>, IApplicationService {
    private final ApplicationRepository repo;
    private final MailService mailService;

    @Override
    public Application create(Application application) {

        return repo.save(application);
    }

    @Override
    public List<Application> createInBulk(List<Application> applicationList){
        return repo.saveAll(applicationList);
    }

    @Override
    public List<Application> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Application> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Application getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public List<Application> getApplicationByVacancyId(Long vacancyId){
        return this.getAll().stream().filter(x->x.getVacancy().getVacancyId().equals(vacancyId)).toList();
    }

    @Override
    public Application update(Application application){
        return repo.save(application);
    }

    @Override
    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(Long id){
        Application application = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        application.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(application);
        return true;
    }

    @Override
    public boolean activate(Long id){
        Application application = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        application.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(application);
        return true;
    }

    @Override
    public List<Application> getByStatus(Enum.ApplicationStatus status){
        return repo.findAll().stream().filter(x->x.getObjectState() == Enum.ObjectState.ACTIVE && x.getStatus() == status).toList();

    }

    @Override
    public Application shortlistApplication(Long id){
        Application application = this.getById(id);
        application.setStatus(Enum.ApplicationStatus.SHORTLISTED);

        mailService.sendMail(new NotificationEmail("Your Application have been approved",
                application.getCandidate().getEmail(), application.getCandidate().getFullName(),
                "Your Application have been approved! Please check your application status.\n " +
                        "Vacancy: "+ application.getVacancy().getName() + " from " + application.getVacancy().getOrganization().getName() +
                        "\n\n Link: " + "http://localhost:4200/application/details/" + application.getApplicationId()));

        return repo.save(application);
    }

    @Override
    public Application declineApplication(Long id){
        Application application = this.getById(id);
        application.setStatus(Enum.ApplicationStatus.DECLINED);

        mailService.sendMail(new NotificationEmail("Your Application have been approved",
                application.getCandidate().getEmail(), application.getCandidate().getFullName(),
                "Your Application have been approved! Please check your application status.\n " +
                        "Vacancy: "+ application.getVacancy().getName() + " from " + application.getVacancy().getOrganization().getName() +
                        "\n\n Link: " + "http://localhost:4200/application/details/" + application.getApplicationId()));

        return repo.save(application);
    }
}