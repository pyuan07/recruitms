package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.Schedule;

public interface IScheduleService {
     Schedule getByApplicationId(Long id);
}
