package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Vacancy;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/vacancy")
@CrossOrigin
public class VacancyController {

    private final VacancyService _vacancyService;

    @Autowired
    public VacancyController(VacancyService service) {
        this._vacancyService = service;
    }

    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies(){
        return ResponseEntity.ok(_vacancyService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Vacancy>> getVacanciesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_vacancyService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Vacancy> getVacancy(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_vacancyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy){
        return ResponseEntity.ok(_vacancyService.create(vacancy));
    }

    @PutMapping
    public ResponseEntity<Vacancy> updateVacancy(@RequestBody Vacancy vacancy){
        return ResponseEntity.ok(_vacancyService.update(vacancy));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteVacancy(@PathVariable("id") UUID id){
        return _vacancyService.delete(id);
    }

}
