package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.enumeration.Enum;

import java.util.List;

public interface IApplicationService{

    List<Application> getByStatus(Enum.ApplicationStatus status);
}
