//package com.recruit.recruitms.controller;
//
//import com.recruit.recruitms.entity.ResumeProgrammingLanguage;
//import com.recruit.recruitms.enumeration.Enum;
//import com.recruit.recruitms.service.impl.ResumeProgrammingLanguageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path="api/v1/resumeProgrammingLanguage")
//@CrossOrigin
//public class ResumeProgrammingLanguageController {
//
//    private final ResumeProgrammingLanguageService _resumeProgrammingLanguageService;
//
//    @Autowired
//    public ResumeProgrammingLanguageController(ResumeProgrammingLanguageService service) {
//        this._resumeProgrammingLanguageService = service;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ResumeProgrammingLanguage>> getAllResumeProgrammingLanguages(){
//        return ResponseEntity.ok(_resumeProgrammingLanguageService.getAll());
//    }
//
//    @GetMapping("/objectState/{objectState}")
//    public ResponseEntity<List<ResumeProgrammingLanguage>> getResumeProgrammingLanguagesByObjectState(@PathVariable String objectState){
//        return ResponseEntity.ok(_resumeProgrammingLanguageService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
//    }
//
//    @GetMapping(path="/id/{id}")
//    public ResponseEntity<ResumeProgrammingLanguage> getResumeProgrammingLanguage(@PathVariable("id") Long id){
//        return ResponseEntity.ok(_resumeProgrammingLanguageService.getById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<ResumeProgrammingLanguage> createResumeProgrammingLanguage(@RequestBody ResumeProgrammingLanguage resumeProgrammingLanguage){
//        return ResponseEntity.ok(_resumeProgrammingLanguageService.create(resumeProgrammingLanguage));
//    }
//
//    @PutMapping
//    public ResponseEntity<ResumeProgrammingLanguage> updateResumeProgrammingLanguage(@RequestBody ResumeProgrammingLanguage resumeProgrammingLanguage){
//        return ResponseEntity.ok(_resumeProgrammingLanguageService.update(resumeProgrammingLanguage));
//    }
//
//    @DeleteMapping(path="{id}")
//    public boolean deleteResumeProgrammingLanguage(@PathVariable("id") Long id){
//        return _resumeProgrammingLanguageService.delete(id);
//    }
//
//}
