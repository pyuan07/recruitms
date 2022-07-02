package com.recruit.recruitms.service;

import com.recruit.recruitms.dto.request.CreateVacancyRequest;
import com.recruit.recruitms.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IVacancyService{

    Vacancy createVacancyByRequest(CreateVacancyRequest request);
}
