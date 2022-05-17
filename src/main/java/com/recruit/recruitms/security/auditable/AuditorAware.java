package com.recruit.recruitms.security.auditable;

import java.util.Optional;

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
