package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.IService;
import com.recruit.recruitms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
@AllArgsConstructor
public class UserService implements IService<User,UUID>, IUserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;



    public User create(User user) {
        if(repo.findByEmail(user.getEmail()).isPresent())
            throw new ApiRequestException(Constants.EMAIL_EXIST);

        if(repo.findByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constants.USERNAME_EXIST);

        //Encode Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public List<User> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    public User getById(UUID id){
        return repo.findUserById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public User update(User user){
        return repo.save(user);
    }

    public boolean delete(UUID id) {
        //if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
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
