package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
    private UUID resumeId;
    private String profilePicture;
    private List<Tag> tags;
    private Country country;
    private User candidate;
    private Integer totalExperienceYear;
    private Float salaryExpectation;
    private String remarks;
    private String resumePdf;

    private Enum.ObjectState objectState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date lastModifiedDate;

    private List<String> tagString;

    public Resume mapToEntity() {
        Resume resume = new Resume(
                this.resumeId,
                this.profilePicture,
                this.candidate,
                this.tags,
                this.country,
                this.totalExperienceYear,
                this.salaryExpectation,
                this.remarks,
                this.resumePdf
        );
        resume.setObjectState(this.objectState);
        resume.setCreatedBy(this.createdBy);
        resume.setCreatedDate(this.createdDate);
        resume.setLastModifiedDate(this.lastModifiedDate);
        resume.setModifiedBy(this.modifiedBy);

        return resume;
    }
}
