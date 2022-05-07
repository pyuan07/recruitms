package com.recruit.recruitms.service;

import com.recruit.recruitms.constant.Constant;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.UserNotFoundException;
import com.recruit.recruitms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public void addNewUser(User user) {
        if(repo.findByEmail(user.getEmail()).isPresent()) throw new IllegalStateException(Constant.EMAIL_EXIST);
        repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public List<User> getActiveUsers(){
        return repo.findAll().stream().filter(x->x.getObjectState() == Enum.ObjectState.ACTIVE).toList();
    }

    public User getUserById(UUID id){
        return repo.getUserById(id).orElseThrow(()->new UserNotFoundException(Constant.NOT_FOUND + " id: "+ id));
    }

    public User getUserByUsername(String username){
        return repo.getUserByUsername(username).orElseThrow(()->new UserNotFoundException(Constant.NOT_FOUND + " username: "+ username));
    }

    public User updateUser(User user){
        return repo.save(user);
    }

    public void deleteUser(UUID id) {
        if(! repo.existsById(id)) throw new IllegalStateException(Constant.NOT_FOUND + " id: "+id);
        repo.deleteById(id);
    }

}
