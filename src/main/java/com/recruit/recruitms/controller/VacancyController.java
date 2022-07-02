package com.recruit.recruitms.controller;

import com.recruit.recruitms.dto.request.CreateVacancyRequest;
import com.recruit.recruitms.dto.request.VacancyDto;
import com.recruit.recruitms.entity.Vacancy;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Vacancy> getVacancy(@PathVariable("id") Long id){
        return ResponseEntity.ok(_vacancyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Vacancy> createVacancy(@RequestBody CreateVacancyRequest request){
        return ResponseEntity.ok(_vacancyService.createVacancyByRequest(request));
    }

    @PutMapping
    public ResponseEntity<Vacancy> updateVacancy(@RequestBody VacancyDto vacancy){
        return ResponseEntity.ok(_vacancyService.updateByRequest(vacancy));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteVacancy(@PathVariable("id") Long id){
        return _vacancyService.delete(id);
    }

}
