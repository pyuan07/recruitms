package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Schedule;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ScheduleRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService implements ICrudService<Schedule, Long>, IScheduleService {
    private final ScheduleRepository repo;

    @Override
    public Schedule create(Schedule schedule) {

        return repo.save(schedule);
    }

    @Override
    public List<Schedule> createInBulk(List<Schedule> schedules){
        return repo.saveAll(schedules);
    }

    @Override
    public List<Schedule> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Schedule> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Schedule getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Schedule getByApplicationId(Long id){
        return this.getByObjectState(Enum.ObjectState.ACTIVE).stream()
                .filter(x->x.getApplication().getApplicationId().equals(id)).findFirst()
                .orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " application id: "+ id));
    }

    @Override
    public Schedule update(Schedule schedule){
        return repo.save(schedule);
    }

    @Override
    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        this.delete(id);
        return true;
    }

    @Override
    public boolean terminate(Long id){
        Schedule schedule = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        schedule.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(schedule);
        return true;
    }

    @Override
    public boolean activate(Long id){
        Schedule schedule = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        schedule.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(schedule);
        return true;
    }
}