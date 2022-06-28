package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Candidate;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.CandidateRepository;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.ICandidateService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidateService implements ICrudService<Candidate, UUID>, ICandidateService {

    private final CandidateRepository repo;
    private final UserService userService;

    @Override
    public Candidate create(Candidate candidate) {
        User user = userService.create(candidate.getUser());
        candidate.setUserId(user.getUserId());
        return repo.save(candidate);
    }

    @Override
    public List<Candidate> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Candidate> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getUser().getObjectState() == objectState).toList();
    }

    @Override
    public Candidate getById(UUID id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Candidate update(Candidate candidate){
        return repo.save(candidate);
    }

    @Override
    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(UUID id){
        Candidate candidate = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        candidate.getUser().setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(candidate);
        return true;
    }

    @Override
    public boolean activate(UUID id){
        Candidate candidate = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        candidate.getUser().setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(candidate);
        return true;
    }
}