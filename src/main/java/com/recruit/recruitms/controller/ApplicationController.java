package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/application")
@CrossOrigin
public class ApplicationController {

    private final ApplicationService _applicationService;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this._applicationService = service;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications(){
        return ResponseEntity.ok(_applicationService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Application>> getApplicationsByObjectState(@PathVariable("objectState") String objectState){
        return ResponseEntity.ok(_applicationService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsByStatus(@PathVariable("status") String status){
        return ResponseEntity.ok(_applicationService.getByStatus(Enum.ApplicationStatus.valueOf(status)));
    }

    @GetMapping("/vacancy/{id}")
    public ResponseEntity<List<Application>> getApplicationByVacancyId(@PathVariable("id") Long id){
        return ResponseEntity.ok(_applicationService.getApplicationByVacancyId(id));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") Long id){
        return ResponseEntity.ok(_applicationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        return ResponseEntity.ok(_applicationService.create(application));
    }

    @PutMapping
    public ResponseEntity<Application> updateApplication(@RequestBody Application application){
        return ResponseEntity.ok(_applicationService.update(application));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteApplication(@PathVariable("id") Long id){
        return _applicationService.delete(id);
    }

    @GetMapping(path="/shortlist/{id}")
    public ResponseEntity<Application> shortlistApplication(@PathVariable("id") Long id){
        return ResponseEntity.ok(_applicationService.shortlistApplication(id));
    }

    @GetMapping(path="/decline/{id}")
    public ResponseEntity<Application> declineApplication(@PathVariable("id") Long id){
        return ResponseEntity.ok(_applicationService.declineApplication(id));
    }

    @GetMapping(path="/complete/{id}")
    public ResponseEntity<Application> acceptApplication(@PathVariable("id") Long id){
        return ResponseEntity.ok(_applicationService.acceptApplication(id));
    }
}
