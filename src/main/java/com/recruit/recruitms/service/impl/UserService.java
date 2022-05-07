package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constant;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService implements IService<User,UUID> {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public User create(User user) {
        if(repo.getByEmail(user.getEmail()).isPresent() || repo.getByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constant.EMAIL_EXIST);

        user.setObjectState(Enum.ObjectState.ACTIVE);

        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public List<User> getActive(){
        return repo.findAll().stream().filter(x->x.getObjectState() == Enum.ObjectState.ACTIVE).toList();
    }

    public User getById(UUID id){
        return repo.getUserById(id).orElseThrow(()-> new ApiRequestException(Constant.NOT_FOUND + " id: "+ id));
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
