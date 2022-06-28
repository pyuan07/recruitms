package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Candidate;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/candidate")
@CrossOrigin
public class CandidateController {

    private final CandidateService _candidateService;

    @Autowired
    public CandidateController(CandidateService service) {
        this._candidateService = service;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates(){
        return ResponseEntity.ok(_candidateService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Candidate>> getCandidatesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_candidateService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_candidateService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.ok(_candidateService.create(candidate));
    }

    @PutMapping
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.ok(_candidateService.update(candidate));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteCandidate(@PathVariable("id") UUID id){
        return _candidateService.delete(id);
    }

}
