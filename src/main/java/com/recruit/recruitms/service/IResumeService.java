package com.recruit.recruitms.service;

import com.recruit.recruitms.dto.request.CreateResumeRequest;
import com.recruit.recruitms.dto.request.ResumeDto;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public interface IResumeService {

    Resume createResumeByRequest(CreateResumeRequest request) throws IOException;
    String uploadResumePdf(MultipartFile file) throws IOException;
    Path downloadResumePdf(String fileName) throws IOException;

    String uploadProfilePicture(MultipartFile file) throws IOException;
    Path downloadProfilePicture(String fileName) throws IOException;

    Resume getResumeByCandidateId(UUID userId);

    Resume updateByRequest(ResumeDto resume);

    List<Tag> extractTagsFromResume(String fileName) throws IOException;

}
