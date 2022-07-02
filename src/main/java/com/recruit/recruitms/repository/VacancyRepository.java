package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {


}
