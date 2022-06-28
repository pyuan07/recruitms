package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/tag")
@CrossOrigin
public class TagController {

    private final TagService _tagService;

    @Autowired
    public TagController(TagService service) {
        this._tagService = service;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags(){
        return ResponseEntity.ok(_tagService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Tag>> getTagsByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_tagService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable("id") Long id){
        return ResponseEntity.ok(_tagService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        return ResponseEntity.ok(_tagService.create(tag));
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        return ResponseEntity.ok(_tagService.update(tag));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteTag(@PathVariable("id") Long id){
        return _tagService.delete(id);
    }

}
