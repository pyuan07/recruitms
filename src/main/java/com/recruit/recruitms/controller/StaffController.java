package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Staff;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/staff")
@CrossOrigin
public class StaffController {

    private final StaffService _staffService;

    @Autowired
    public StaffController(StaffService service) {
        this._staffService = service;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaffs(){
        return ResponseEntity.ok(_staffService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Staff>> getStaffsByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_staffService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_staffService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff){
        return ResponseEntity.ok(_staffService.create(staff));
    }

    @PutMapping
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff){
        return ResponseEntity.ok(_staffService.update(staff));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteStaff(@PathVariable("id") UUID id){
        return _staffService.delete(id);
    }

}
