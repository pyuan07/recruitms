package com.recruit.recruitms.security.auditable;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.security.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@AllArgsConstructor
public class AuditorAware implements org.springframework.data.domain.AuditorAware<String> {

    private AuthService authService;


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(this.authService.getCurrentUser().getUsername()).filter(s-> !s.isEmpty());
        //return Optional.empty();
    }

//    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
//        return Optional.ofNullable(((User) authentication.getPrincipal()).getUsername());
//    }
}
