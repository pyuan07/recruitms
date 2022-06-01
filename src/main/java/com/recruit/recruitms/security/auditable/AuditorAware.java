package com.recruit.recruitms.security.auditable;

import com.recruit.recruitms.security.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

@NoArgsConstructor
public class AuditorAware implements org.springframework.data.domain.AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            return Optional.empty();
        }
        else{
            try{
                Jwt principal = (Jwt) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
                return Optional.ofNullable(principal.getSubject());
            }catch(Exception ex){
                return Optional.empty();
            }

        }

        //return Optional.of("PYUAN07");
        //return Optional.empty();
    }

}
