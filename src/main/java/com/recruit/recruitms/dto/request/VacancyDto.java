package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.entity.Vacancy;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto{
    private Long vacancyId;
    private String name;
    private String description;
    private List<Tag> tags;
    private Country country;
    private Organization organization;
    private Integer numberOfOpening;
    private Float minSalary;
    private Float maxSalary;
    private Boolean enableQuiz;
    private String remarks;
    private Enum.ObjectState objectState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date lastModifiedDate;

    private List<String> tagString;

    public Vacancy mapToEntity(){
        Vacancy vacancy = new Vacancy(
                this.getVacancyId(),
                this.getName(),
                this.getDescription(),
                this.getTags(),
                this.getCountry(),
                this.getOrganization(),
                this.getNumberOfOpening(),
                this.getMinSalary(),
                this.getMaxSalary(),
                this.getEnableQuiz(),
                this.getRemarks()
        );

        vacancy.setObjectState(this.getObjectState());
        vacancy.setCreatedDate(this.getCreatedDate());
        vacancy.setCreatedBy(this.getCreatedBy());
        vacancy.setModifiedBy(this.getModifiedBy());
        vacancy.setLastModifiedDate(this.getLastModifiedDate());

        return vacancy;
    }
}
