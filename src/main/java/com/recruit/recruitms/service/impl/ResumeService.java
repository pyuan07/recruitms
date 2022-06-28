package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ResumeRepository;
import com.recruit.recruitms.service.IResumeService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ResumeService implements ICrudService<Resume, UUID>, IResumeService {
    private final ResumeRepository repo;

    @Override
    public Resume create(Resume resume) {

        return repo.save(resume);
    }

    @Override
    public List<Resume> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Resume> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Resume getById(UUID id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Resume update(Resume resume){
        return repo.save(resume);
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
        Resume resume = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resume.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(resume);
        return true;
    }

    @Override
    public boolean activate(UUID id){
        Resume resume = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resume.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(resume);
        return true;
    }
}