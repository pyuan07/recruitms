package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.ScheduleTimeslot;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ScheduleTimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/scheduleTimeslot")
@CrossOrigin
public class ScheduleTimeslotController {

    private final ScheduleTimeslotService _scheduleTimeslotService;

    @Autowired
    public ScheduleTimeslotController(ScheduleTimeslotService service) {
        this._scheduleTimeslotService = service;
    }

    @GetMapping
    public ResponseEntity<List<ScheduleTimeslot>> getAllScheduleTimeslots(){
        return ResponseEntity.ok(_scheduleTimeslotService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<ScheduleTimeslot>> getScheduleTimeslotsByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_scheduleTimeslotService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<ScheduleTimeslot> getScheduleTimeslot(@PathVariable("id") Long id){
        return ResponseEntity.ok(_scheduleTimeslotService.getById(id));
    }

    @GetMapping(path="/vacancy/{id}")
    public ResponseEntity<List<ScheduleTimeslot>> getScheduleTimeslotByVacancyId(@PathVariable("id") Long id){
        return ResponseEntity.ok(_scheduleTimeslotService.getTimeslotsByVacancyId(id));
    }

    @PostMapping
    public ResponseEntity<ScheduleTimeslot> createScheduleTimeslot(@RequestBody ScheduleTimeslot scheduleTimeslot){
        return ResponseEntity.ok(_scheduleTimeslotService.create(scheduleTimeslot));
    }

    @PutMapping
    public ResponseEntity<ScheduleTimeslot> updateScheduleTimeslot(@RequestBody ScheduleTimeslot scheduleTimeslot){
        return ResponseEntity.ok(_scheduleTimeslotService.update(scheduleTimeslot));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteScheduleTimeslot(@PathVariable("id") Long id){
        return _scheduleTimeslotService.delete(id);
    }

}
