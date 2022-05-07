package com.recruit.recruitms.service;

import com.recruit.recruitms.constant.Constant;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public User create(User user) {
        if(repo.getByEmail(user.getEmail()).isPresent() || repo.getByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constant.EMAIL_EXIST);
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public List<User> getActive(){
        return repo.findAll().stream().filter(x->x.getObjectState() == Enum.ObjectState.ACTIVE).toList();
    }

    public User getById(UUID id){
        return repo.getById(id);
    }

    public User getByUsername(String username){
        return repo.getByUsername(username).orElseThrow(()-> new ApiRequestException(Constant.NOT_FOUND + " username: "+ username));
    }

    public User update(User user){
        return repo.save(user);
    }

    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constant.NOT_FOUND + " id: "+id);
        repo.deleteById(id);
        return true;
    }

}
