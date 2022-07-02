package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.enumeration.Enum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVacancyRequest {
    private String name;
    private String description;
    private List<String> tags;
    private String countryISO;
    private UUID organizationId;
    private Integer numberOfOpening;
    private Float minSalary;
    private Float maxSalary;
    private Boolean enableQuiz;
    private String remarks;
    private Enum.ObjectState objectState;

}
