package com.recruit.recruitms.service;

import com.recruit.recruitms.dto.request.CreateResumeRequest;
import com.recruit.recruitms.entity.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

public interface IResumeService {

    Resume createResumeByRequest(CreateResumeRequest request) throws IOException;
    String uploadResumePdf(MultipartFile file) throws IOException;
    Path downloadResumePdf(String fileName) throws IOException;

    String uploadProfilePicture(MultipartFile file) throws IOException;
    Path downloadProfilePicture(String fileName) throws IOException;

}
