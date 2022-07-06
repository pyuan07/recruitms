package com.recruit.recruitms.controller;

import com.recruit.recruitms.dto.request.CreateResumeRequest;
import com.recruit.recruitms.dto.request.ResumeDto;
import com.recruit.recruitms.dto.response.UploadResponse;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/resume")
@CrossOrigin
public class ResumeController {

    private final ResumeService _resumeService;

    @Autowired
    public ResumeController(ResumeService service) {
        this._resumeService = service;
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes(){
        return ResponseEntity.ok(_resumeService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Resume>> getResumesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_resumeService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping("/getResumeByCandidateId/{userId}")
    public ResponseEntity<Resume> getResumeByCandidateId(@PathVariable UUID userId){
        return ResponseEntity.ok(_resumeService.getResumeByCandidateId(userId));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_resumeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody CreateResumeRequest request) throws IOException {
        return ResponseEntity.ok(_resumeService.createResumeByRequest(request));
    }

    @PutMapping
    public ResponseEntity<Resume> updateResume(@RequestBody ResumeDto resume){
        return ResponseEntity.ok(_resumeService.updateByRequest(resume));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteResume(@PathVariable("id") UUID id){
        return _resumeService.delete(id);
    }

    @PostMapping(path="/upload/pdf")
    public ResponseEntity<UploadResponse> uploadResumePdf(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setFilename(_resumeService.uploadResumePdf(multipartFile));
        return ResponseEntity.ok(uploadResponse);
    }

    @GetMapping(path="download/pdf/{filename}")
    public ResponseEntity<Resource> downloadResumePdf(@PathVariable("filename") String filename) throws IOException {
        Path filePath = _resumeService.downloadResumePdf(filename);
        Resource resource = new UrlResource(filePath.toUri());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name",filename);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;File-Name=" + resource.getFilename());

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }

    @PostMapping(path="upload/image")
    public ResponseEntity<UploadResponse> uploadProfilePic(@RequestParam("imageFile")MultipartFile multipartFile) throws IOException {
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setFilename(_resumeService.uploadProfilePicture(multipartFile));
        return ResponseEntity.ok(uploadResponse);
    }

    @GetMapping(path="download/image/{filename}")
    public ResponseEntity<Resource> downloadProfilePic(@PathVariable("filename") String filename) throws IOException {
        Path filePath = _resumeService.downloadProfilePicture(filename);
        Resource resource = new UrlResource(filePath.toUri());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name",filename);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;File-Name=" + resource.getFilename());

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }
}
