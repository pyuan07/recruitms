package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.VerificationToken;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationTokenService {
    private final VerificationTokenRepository repo;

    public VerificationToken create(VerificationToken tag) {
        return repo.save(tag);
    }

    public Optional<VerificationToken> getByToken(String token){
        return repo.findByToken(token);
    }

    public VerificationToken getByEmail(String email){
        return this.getAll().stream().filter(x->x.getUser().getEmail().equals(email)).findFirst().orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " email: "+ email));
    }

    public List<VerificationToken> getAll() {
        return repo.findAll();
    }

    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        repo.deleteById(id);
        return true;
    }

}
