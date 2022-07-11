package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.ScheduleTimeslot;
import com.recruit.recruitms.entity.Tag;

import java.util.List;

public interface IScheduleTimeslotService {
    List<ScheduleTimeslot> getTimeslotsByVacancyId(Long id);
}
