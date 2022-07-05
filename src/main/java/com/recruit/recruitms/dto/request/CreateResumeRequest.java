package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.enumeration.Enum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResumeRequest {
    private String profilePicture;
//    private List<ProgrammingLanguageSkill> ProgrammingLanguageSkillList;
    private UUID owner;
    private List<String> tags;
    private String countryISO;
    private Integer totalExperienceYear;
    private Float salaryExpectation;
    private String remarks;
    private String resumePdf;
    private Enum.ObjectState objectState;
}

//class ProgrammingLanguageSkill{
//    private Long programmingLanguageId;
//    private Integer experienceYear;
//}