package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.ScheduleTimeslot;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ScheduleTimeslotRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IScheduleTimeslotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleTimeslotService implements ICrudService<ScheduleTimeslot, Long>, IScheduleTimeslotService {
    private final ScheduleTimeslotRepository repo;

    @Override
    public ScheduleTimeslot create(ScheduleTimeslot timeslot) {
        return repo.save(timeslot);
    }

    @Override
    public List<ScheduleTimeslot> createInBulk(List<ScheduleTimeslot> timeslots){
        return repo.saveAll(timeslots);
    }

    @Override
    public List<ScheduleTimeslot> getAll() {
        return repo.findAll();
    }

    @Override
    public List<ScheduleTimeslot> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public ScheduleTimeslot getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public ScheduleTimeslot update(ScheduleTimeslot timeslot){
        return repo.save(timeslot);
    }

    @Override
    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean terminate(Long id){
        ScheduleTimeslot timeslot = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        timeslot.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(timeslot);
        return true;
    }

    @Override
    public boolean activate(Long id){
        ScheduleTimeslot timeslot = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        timeslot.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(timeslot);
        return true;
    }

    @Override
    public List<ScheduleTimeslot> getTimeslotsByVacancyId(Long id) {
        return this.getAll().stream().filter(x->x.getVacancy().getVacancyId().equals(id)).toList();
    }
}