package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.dto.request.CreateResumeRequest;
import com.recruit.recruitms.dto.request.ExtractTagsRequest;
import com.recruit.recruitms.dto.request.ResumeDto;
import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.ResumeRepository;
import com.recruit.recruitms.security.auditable.AuditorAware;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IResumeService;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.nio.file.Files.copy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@AllArgsConstructor
public class ResumeService implements ICrudService<Resume, UUID>, IResumeService {
    private final ResumeRepository repo;
    private final CountryService _countryService;
    private final UserService _userService;
    private final TagService _tagService;

    public static final String PDF_DIRECTORY = "D:\\User's File\\Downloads\\uploads\\resume";
    public static final String IMAGE_DIRECTORY = "D:\\User's File\\Downloads\\uploads\\profilePicture";



    @Override
    public Resume create(Resume resume) {

        return repo.save(resume);
    }

    @Override
    public Resume createResumeByRequest(CreateResumeRequest request) throws IOException {
        List<String> newTagString = request.getTags().stream().filter(tag -> ! _tagService.getAll().stream().map(Tag::getName).toList().contains(tag)).toList();

        List<Tag> newTagList = newTagString.stream().map(x-> new Tag(x, Enum.TagType.Vacancy,0L)).toList();
        _tagService.createInBulk(newTagList);

        List<Tag> selectedTags = request.getTags().stream().map(_tagService::getByName).toList();
        //Update TotalUsed of Tag
        selectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() + 1);
            _tagService.update(x);
        });


        Resume resume = new Resume(
                request.getProfilePicture(),
                _userService.getById(request.getOwner()),
                selectedTags,
                _countryService.getByIso(request.getCountryISO()),
                request.getTotalExperienceYear(),
                request.getSalaryExpectation(),
                request.getRemarks(),
                request.getResumePdf(),
                request.getObjectState()
            );
        return this.create(resume);
    }

    @Override
    public List<Resume> createInBulk(List<Resume> resumeList){
        return repo.saveAll(resumeList);
    }

    @Override
    public List<Resume> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Resume> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Resume getById(UUID id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Resume update(Resume resume){
        return repo.save(resume);
    }

    @Override
    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(UUID id){
        Resume resume = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resume.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(resume);
        return true;
    }

    @Override
    public boolean activate(UUID id){
        Resume resume = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        resume.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(resume);
        return true;
    }

    @Override
    public String uploadResumePdf(MultipartFile file) throws IOException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm") ;

        AuditorAware audit = new AuditorAware();

        String fileName = file.getOriginalFilename();
        if(fileName == null) throw new NullPointerException("The filename does not exist.");
        int lastDotIndex = fileName.lastIndexOf('.');
        String saveName = fileName.substring(0, lastDotIndex) + "_" + audit.getCurrentAuditor().orElse("") + "_" + dateFormat.format(date) + fileName.substring(lastDotIndex);
        Path fileStorage = Paths.get(PDF_DIRECTORY,saveName).toAbsolutePath().normalize();
        copy(file.getInputStream(),fileStorage,REPLACE_EXISTING);

        return saveName;
    }

    @Override
    public Path downloadResumePdf(String fileName) throws IOException {
        Path filePath = Paths.get(PDF_DIRECTORY).toAbsolutePath().normalize().resolve(fileName);

        if(!Files.exists(filePath)){
            throw new FileNotFoundException(fileName + "was not found on the server");
        }

        return filePath;
    }

    @Override
    public String uploadProfilePicture(MultipartFile file) throws IOException {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm") ;

        AuditorAware audit = new AuditorAware();

        String fileName = file.getOriginalFilename();
        if(fileName == null) throw new NullPointerException("The filename does not exist.");
        int lastDotIndex = fileName.lastIndexOf('.');
        String saveName = fileName.substring(0, lastDotIndex) + "_" + audit.getCurrentAuditor().orElse("") + "_" + dateFormat.format(date) + fileName.substring(lastDotIndex);
        Path fileStorage = Paths.get(IMAGE_DIRECTORY,saveName).toAbsolutePath().normalize();
        copy(file.getInputStream(),fileStorage,REPLACE_EXISTING);

        return saveName;
    }

    @Override
    public Path downloadProfilePicture(String fileName) throws IOException {
        Path filePath = Paths.get(IMAGE_DIRECTORY).toAbsolutePath().normalize().resolve(fileName);

        if(!Files.exists(filePath)){
            throw new FileNotFoundException(fileName + " was not found on the server");
        }

        return filePath;
    }

    @Override
    public Resume getResumeByCandidateId(UUID userId) {
        return this.getByObjectState(Enum.ObjectState.ACTIVE)
                .stream()
                .filter(x->x.getCandidate().getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new ApiRequestException("Resume not found."));
    }

    @Override
    public Resume updateByRequest(ResumeDto resume) {
        List<String> newTagString = resume.getTagString().stream().filter(tag -> ! _tagService.getAll().stream().map(Tag::getName).toList().contains(tag)).toList();
        List<Tag> newTagList = newTagString.stream().map(x-> new Tag(x, Enum.TagType.Vacancy,0L)).toList();
        _tagService.createInBulk(newTagList);

        //Update TotalUsed of Tag
        List<Tag> oldSelectedTags = resume.getTags();
        oldSelectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() - 1);
            _tagService.update(x);
        });

        List<Tag> selectedTags = resume.getTagString().stream().map(_tagService::getByName).toList();
        selectedTags.forEach(x->{
            x.setTotalUsed(x.getTotalUsed() + 1);
            _tagService.update(x);
        });

        resume.setTags(selectedTags);
        return this.update(resume.mapToEntity());
    }

    @Override
    public List<Tag> extractTagsFromResume(String fileName) throws IOException {

        Path fileStorage = Paths.get(PDF_DIRECTORY,fileName);

        File f = new File(String.valueOf(fileStorage));

        String parsedText;
        PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
        parser.parse();

        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        parsedText = pdfStripper.getText(pdDoc);

        return _tagService.extractTagFromString(new ExtractTagsRequest(parsedText));
    }
}