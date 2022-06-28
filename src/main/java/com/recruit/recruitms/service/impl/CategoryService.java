package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Category;
import com.recruit.recruitms.entity.Category;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.CategoryRepository;
import com.recruit.recruitms.service.ICategoryService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICrudService<Category, Long>, ICategoryService {
    private final CategoryRepository repo;

    @Override
    public Category create(Category category) {

        return repo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Category> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Category getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Category update(Category category){
        return repo.save(category);
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
        Category category = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        category.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(category);
        return true;
    }

    @Override
    public boolean activate(Long id){
        Category category = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        category.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(category);
        return true;
    }
}
