package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.IService;
import com.recruit.recruitms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService implements IService<User,UUID>, IUserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public User create(User user) {
        if(repo.findByEmail(user.getEmail()).isPresent() || repo.findByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constants.EMAIL_EXIST);

        user.setObjectState(Enum.ObjectState.CREATED);

        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public List<User> getActive(){
        return repo.findAll().stream().filter(x->x.getObjectState() == Enum.ObjectState.ACTIVE).toList();
    }

    public User getById(UUID id){
        return repo.findUserById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public User update(User user){
        return repo.save(user);
    }

    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        repo.deleteById(id);
        return true;
    }

    public boolean terminate(UUID id){
        User user = repo.findUserById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        user.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(user);
        return true;
    }

    public boolean activate(UUID id){
        User user = repo.findUserById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        user.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(user);
        return true;
    }


    public User getByUsername(String username){
        return repo.findByUsername(username).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " username: "+ username));
    }
}
