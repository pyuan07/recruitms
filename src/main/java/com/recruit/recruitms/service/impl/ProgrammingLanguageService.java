//package com.recruit.recruitms.service.impl;
//
//import com.recruit.recruitms.constant.Constants;
//import com.recruit.recruitms.entity.ProgrammingLanguage;
//import com.recruit.recruitms.enumeration.Enum;
//import com.recruit.recruitms.exception.ApiRequestException;
//import com.recruit.recruitms.repository.ProgrammingLanguageRepository;
//import com.recruit.recruitms.service.IProgrammingLanguageService;
//import com.recruit.recruitms.service.ICrudService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class ProgrammingLanguageService implements ICrudService<ProgrammingLanguage, Long>, IProgrammingLanguageService {
//    private final ProgrammingLanguageRepository repo;
//
//    @Override
//    public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) {
//
//        return repo.save(programmingLanguage);
//    }
//
//    @Override
//    public List<ProgrammingLanguage> createInBulk(List<ProgrammingLanguage> programmingLanguageList){
//        return repo.saveAll(programmingLanguageList);
//    }
//
//    @Override
//    public List<ProgrammingLanguage> getAll() {
//        return repo.findAll();
//    }
//
//    @Override
//    public List<ProgrammingLanguage> getByObjectState(Enum.ObjectState objectState) {
//        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
//    }
//
//    @Override
//    public ProgrammingLanguage getById(Long id){
//        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
//    }
//
//    @Override
//    public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage){
//        return repo.save(programmingLanguage);
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
//        //repo.deleteById(id);
//        this.terminate(id);
//        return true;
//    }
//
//    @Override
//    public boolean terminate(Long id){
//        ProgrammingLanguage programmingLanguage = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
//        programmingLanguage.setObjectState(Enum.ObjectState.TERMINATED);
//        repo.save(programmingLanguage);
//        return true;
//    }
//
//    @Override
//    public boolean activate(Long id){
//        ProgrammingLanguage programmingLanguage = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
//        programmingLanguage.setObjectState(Enum.ObjectState.ACTIVE);
//        repo.save(programmingLanguage);
//        return true;
//    }
//}
