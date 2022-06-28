package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.ProgrammingLanguage;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ProgrammingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/programmingLanguage")
@CrossOrigin
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService _programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService service) {
        this._programmingLanguageService = service;
    }

    @GetMapping
    public ResponseEntity<List<ProgrammingLanguage>> getAllProgrammingLanguages(){
        return ResponseEntity.ok(_programmingLanguageService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<ProgrammingLanguage>> getProgrammingLanguagesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_programmingLanguageService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<ProgrammingLanguage> getProgrammingLanguage(@PathVariable("id") Long id){
        return ResponseEntity.ok(_programmingLanguageService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProgrammingLanguage> createProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage){
        return ResponseEntity.ok(_programmingLanguageService.create(programmingLanguage));
    }

    @PutMapping
    public ResponseEntity<ProgrammingLanguage> updateProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage){
        return ResponseEntity.ok(_programmingLanguageService.update(programmingLanguage));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteProgrammingLanguage(@PathVariable("id") Long id){
        return _programmingLanguageService.delete(id);
    }

}
