package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Category;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService _categoryService;

    @Autowired
    public CategoryController(CategoryService service) {
        this._categoryService = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(_categoryService.getAll());
    }

    @GetMapping("/objectState/{objectState}")
    public ResponseEntity<List<Category>> getCategoriesByObjectState(@PathVariable String objectState){
        return ResponseEntity.ok(_categoryService.getByObjectState(Enum.ObjectState.valueOf(objectState)));
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(_categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(_categoryService.create(category));
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(_categoryService.update(category));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteCategory(@PathVariable("id") Long id){
        return _categoryService.delete(id);
    }

}
