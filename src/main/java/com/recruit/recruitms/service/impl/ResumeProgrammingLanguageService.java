package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.ResumeProgrammingLanguage;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ResumeProgrammingLanguageRepository;
import com.recruit.recruitms.service.IResumeProgrammingLanguageService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ResumeProgrammingLanguageService implements ICrudService<ResumeProgrammingLanguage, Long>, IResumeProgrammingLanguageService {
    private final ResumeProgrammingLanguageRepository repo;

    @Override
    public ResumeProgrammingLanguage create(ResumeProgrammingLanguage resumeProgrammingLanguage) {

        return repo.save(resumeProgrammingLanguage);
    }

    @Override
    public List<ResumeProgrammingLanguage> getAll() {
        return repo.findAll();
    }

    @Override
    public List<ResumeProgrammingLanguage> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public ResumeProgrammingLanguage getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public ResumeProgrammingLanguage update(ResumeProgrammingLanguage resumeProgrammingLanguage){
        return repo.save(resumeProgrammingLanguage);
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
        ResumeProgrammingLanguage resumeProgrammingLanguage = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resumeProgrammingLanguage.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(resumeProgrammingLanguage);
        return true;
    }

    @Override
    public boolean activate(Long id){
        ResumeProgrammingLanguage resumeProgrammingLanguage = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resumeProgrammingLanguage.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(resumeProgrammingLanguage);
        return true;
    }
}