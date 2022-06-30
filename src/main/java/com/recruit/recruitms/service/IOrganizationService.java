package com.recruit.recruitms.service;

import com.recruit.recruitms.dto.request.CreateOrganizationRequest;
import com.recruit.recruitms.entity.Organization;

public interface IOrganizationService {

    Organization createOrganizationByRequest(CreateOrganizationRequest request);
}
