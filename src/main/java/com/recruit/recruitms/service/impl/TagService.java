package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.dto.request.ExtractTagsRequest;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.TagRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.ITagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@Service
@Slf4j
@AllArgsConstructor
public class TagService implements ICrudService<Tag, Long>, ITagService {
    private final TagRepository repo;

    @Override
    public Tag create(Tag tag) {
        if(repo.findByName(tag.getName()).isPresent())
            throw new ApiRequestException("The tag name ["+ tag.getName() +"] already exist.");


        return repo.save(tag);
    }

    @Override
    public List<Tag> createInBulk(List<Tag> tags){
        return repo.saveAll(tags);
    }

    @Override
    public List<Tag> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Tag> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Tag getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Tag getByName(String name){
        return repo.findByName(name).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " name: "+ name));
    }

    @Override
    public List<Tag> extractTagFromString(ExtractTagsRequest request) {
        List<Tag> tagsFound = new ArrayList<>();
        //Tokenizers
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String[] rawTermArray = simpleTokenizer.tokenize(request.getRaw());
        List<Tag> allTags = this.getByObjectState(Enum.ObjectState.ACTIVE);

        for (String term : rawTermArray) {
            Optional<Tag> foundTag = allTags.stream().filter(x->x.getName().toLowerCase().contains(term.toLowerCase())).findFirst();
            if(foundTag.isPresent() && tagsFound.stream().noneMatch(x->x.getTagId().equals(foundTag.get().getTagId()))){
                tagsFound.add(foundTag.get());
            }
        }

        return tagsFound;
    }

    @Override
    public Tag update(Tag tag){
        return repo.save(tag);
    }

    @Override
    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(Long id){
        Tag tag = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        tag.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(tag);
        return true;
    }

    @Override
    public boolean activate(Long id){
        Tag tag = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        tag.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(tag);
        return true;
    }
}