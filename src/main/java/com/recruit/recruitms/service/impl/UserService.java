package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Candidate;
import com.recruit.recruitms.entity.Employer;
import com.recruit.recruitms.entity.Staff;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.CandidateRepository;
import com.recruit.recruitms.repository.EmployerRepository;
import com.recruit.recruitms.repository.StaffRepository;
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
    private final StaffRepository staffRepo;
    private final EmployerRepository employerRepo;
    private final CandidateRepository candidateRepo;

    private final PasswordEncoder passwordEncoder;



    public User create(User user) {
        if(userRepo.findByEmail(user.getEmail()).isPresent())
            throw new ApiRequestException(Constants.EMAIL_EXIST);

        if(userRepo.findByUsername(user.getUsername()).isPresent())
            throw new ApiRequestException(Constants.USERNAME_EXIST);

        //Encode Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User newUser = userRepo.save(user);

        switch (user.getRoles()){
            case STAFF -> staffRepo.save(new Staff(newUser.getUserId(),newUser));
            case EMPLOYER -> employerRepo.save(new Employer(newUser.getUserId(),newUser));
            case CANDIDATE -> candidateRepo.save(new Candidate(newUser.getUserId(),newUser));
        }

        return newUser;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> getByObjectState(Enum.ObjectState objectState) {
        return userRepo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    public User getById(UUID id){
        return userRepo.findUserByUserId(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public User update(User user){
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
}
