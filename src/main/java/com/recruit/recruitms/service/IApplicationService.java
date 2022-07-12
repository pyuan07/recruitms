package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.enumeration.Enum;

import java.util.List;

public interface IApplicationService{

    List<Application> getByStatus(Enum.ApplicationStatus status);
    public List<Application> getApplicationByVacancyId(Long vacancyId);
    Application shortlistApplication(Long id);
    Application declineApplication(Long id);

    Application acceptApplication(Long id);
}
