package com.recruit.recruitms.dto.response;

import com.recruit.recruitms.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String authenticationToken;
    //String refreshToken;
    //private Instant expiresAt;
    private User logonUser;
}
