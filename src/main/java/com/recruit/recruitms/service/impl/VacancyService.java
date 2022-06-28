package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Vacancy;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.VacancyRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IVacancyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VacancyService implements ICrudService<Vacancy, UUID>, IVacancyService {
    private final VacancyRepository repo;

    public Vacancy create(Vacancy vacancy) {

        return repo.save(vacancy);
    }

    public List<Vacancy> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Vacancy> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    public Vacancy getById(UUID id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public Vacancy update(Vacancy vacancy){
        return repo.save(vacancy);
    }

    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    public boolean terminate(UUID id){
        Vacancy vacancy = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        vacancy.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(vacancy);
        return true;
    }

    public boolean activate(UUID id){
        Vacancy vacancy = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        vacancy.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(vacancy);
        return true;
    }
}
