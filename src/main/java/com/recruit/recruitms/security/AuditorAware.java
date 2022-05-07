package com.recruit.recruitms.security;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.repository.UserRepository;
import com.recruit.recruitms.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public class AuditorAware implements org.springframework.data.domain.AuditorAware<String> {

//    private Optional<User> currentUser;
//    private final UserRepository _userRepo;
//
//    @Autowired
//    public AuditorAware(UserRepository userRepo) {
//        this._userRepo = userRepo;
//    }
//
//    public void setCurrentUser(UUID idUser) {
//        this.currentUser = _userRepo.getUserById(idUser);
//    }

    @Override
    public Optional<String> getCurrentAuditor() {
        //return Optional.ofNullable(currentUser.get().getUsername()).filter(s-> !s.isEmpty());
        return Optional.empty();
    }
}
