package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Schedule;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/schedule")
@CrossOrigin
public class ScheduleController {

    private final ScheduleService _scheduleService;

    @Autowired
    public ScheduleController(ScheduleService service) {
        this._scheduleService = service;
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules(){
        return ResponseEntity.ok(_scheduleService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Schedule>> getSchedulesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_scheduleService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Schedule> getScheduleByApplicationId(@PathVariable("id") Long id){
        return ResponseEntity.ok(_scheduleService.getByApplicationId(id));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable("id") Long id){
        return ResponseEntity.ok(_scheduleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.ok(_scheduleService.create(schedule));
    }

    @PutMapping
    public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.ok(_scheduleService.update(schedule));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteSchedule(@PathVariable("id") Long id){
        return _scheduleService.delete(id);
    }

}
