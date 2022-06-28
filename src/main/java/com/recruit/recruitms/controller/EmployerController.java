package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Employer;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/employer")
@CrossOrigin
public class EmployerController {

    private final EmployerService _employerService;

    @Autowired
    public EmployerController(EmployerService service) {
        this._employerService = service;
    }

    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers(){
        return ResponseEntity.ok(_employerService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Employer>> getEmployersByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_employerService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_employerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer){
        return ResponseEntity.ok(_employerService.create(employer));
    }

    @PutMapping
    public ResponseEntity<Employer> updateEmployer(@RequestBody Employer employer){
        return ResponseEntity.ok(_employerService.update(employer));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteEmployer(@PathVariable("id") UUID id){
        return _employerService.delete(id);
    }

}
