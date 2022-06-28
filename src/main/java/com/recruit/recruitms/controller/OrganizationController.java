package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/organization")
@CrossOrigin
public class OrganizationController {

    private final OrganizationService _organizationService;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this._organizationService = service;
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations(){
        return ResponseEntity.ok(_organizationService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Organization>> getOrganizationsByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_organizationService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("id") Long id){
        return ResponseEntity.ok(_organizationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization){
        return ResponseEntity.ok(_organizationService.create(organization));
    }

    @PutMapping
    public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization){
        return ResponseEntity.ok(_organizationService.update(organization));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteOrganization(@PathVariable("id") Long id){
        return _organizationService.delete(id);
    }

}
