package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Application;
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

    @Override
    public Application create(Application application) {

        return repo.save(application);
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
}