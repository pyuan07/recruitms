package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Employer;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.EmployerRepository;
import com.recruit.recruitms.service.IEmployerService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployerService implements ICrudService<Employer, UUID>, IEmployerService {
    private final EmployerRepository repo;
    private final UserService userService;

    @Override
    public Employer create(Employer employer) {
        User user = userService.create(employer.getUser());
        employer.setUserId(user.getUserId());
        return repo.save(employer);
    }

    @Override
    public List<Employer> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Employer> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getUser().getObjectState() == objectState).toList();
    }

    @Override
    public Employer getById(UUID id){
        return repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Employer update(Employer employer){
        return repo.save(employer);
    }

    @Override
    public boolean delete(UUID id) {
        if(! repo.existsById(userService.getById(id))) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(UUID id){
        Employer employer = repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        employer.getUser().setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(employer);
        return true;
    }

    @Override
    public boolean activate(UUID id){
        Employer employer = repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        employer.getUser().setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(employer);
        return true;
    }
}

