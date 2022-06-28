package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/resume")
@CrossOrigin
public class ResumeController {

    private final ResumeService _resumeService;

    @Autowired
    public ResumeController(ResumeService service) {
        this._resumeService = service;
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes(){
        return ResponseEntity.ok(_resumeService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Resume>> getResumesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_resumeService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_resumeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume){
        return ResponseEntity.ok(_resumeService.create(resume));
    }

    @PutMapping
    public ResponseEntity<Resume> updateResume(@RequestBody Resume resume){
        return ResponseEntity.ok(_resumeService.update(resume));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteResume(@PathVariable("id") UUID id){
        return _resumeService.delete(id);
    }

}
