package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Schedule;
import com.recruit.recruitms.entity.ScheduleTimeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleTimeslotRepository extends JpaRepository<ScheduleTimeslot, Long> {

}
