package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements ICrudService<User,UUID>, IUserService {

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;



    public User create(User user) {
        if(userRepo.findByEmail(user.getEmail()).isPresent())
            throw new ApiRequestException(Constants.EMAIL_EXIST);

        if(userRepo.findByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constants.USERNAME_EXIST);

        //Encode Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

    @Override
    public List<User> createInBulk(List<User> userList){
        userList.forEach( user -> {
            if(userRepo.findByEmail(user.getEmail()).isPresent())
                throw new ApiRequestException(Constants.EMAIL_EXIST);

            if(userRepo.findByUsername(user.getUsername()).isPresent())
                throw new ApiRequestException(Constants.USERNAME_EXIST);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
        });

        return userRepo.saveAll(userList);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public List<User> getByRole(Enum.Role role) {
        return this.getByObjectState(Enum.ObjectState.ACTIVE).stream().filter(x->x.getRoles().equals(role)).toList();
    }

    @Override
    public List<User> getByObjectState(Enum.ObjectState objectState) {
        return userRepo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    public User getById(UUID id){
        return userRepo.findUserByUserId(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public User update(User user){
        //Encode Password
        if(!user.getPassword().equals(this.getById(user.getUserId()).getPassword())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    public boolean delete(UUID id) {
        //if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    public boolean terminate(UUID id){
        User user = userRepo.findUserByUserId(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        user.setObjectState(Enum.ObjectState.TERMINATED);
        userRepo.save(user);
        return true;
    }

    public boolean activate(UUID id){
        User user = userRepo.findUserByUserId(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        user.setObjectState(Enum.ObjectState.ACTIVE);
        userRepo.save(user);
        return true;
    }


    public User getByUsername(String username){
        return userRepo.findByUsername(username).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " username: "+ username));
    }

    public User getByEmail(String email){
        return userRepo.findByEmail(email).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " email: "+ email));
    }
}
