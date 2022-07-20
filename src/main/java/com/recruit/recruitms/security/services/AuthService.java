package com.recruit.recruitms.security.services;

import com.recruit.recruitms.dto.request.LoginRequest;
import com.recruit.recruitms.dto.request.RegisterRequest;
import com.recruit.recruitms.dto.response.AuthenticationResponse;
import com.recruit.recruitms.dto.NotificationEmail;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.entity.VerificationToken;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.security.jwt.JwtProvider;
import com.recruit.recruitms.service.impl.MailService;
import com.recruit.recruitms.service.impl.UserService;
import com.recruit.recruitms.service.impl.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    private final VerificationTokenService verificationTokenService;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    //private final RefreshTokenService refreshTokenService;

    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFullName(registerRequest.getFullName());
        user.setGender(registerRequest.getGender());
        user.setObjectState(Enum.ObjectState.CREATED);
        user.setRoles(registerRequest.getRole());

        userService.create(user);

        String token = generateVerificationToken(user);


        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), user.getFullName(),"Thank you for signing up to RecruIT Management System, " +
                "please click on the below url to activate your account : " +
                "http://localhost:055117/api/auth/accountVerification/" + token,""));
    }

    public void resendVerificationEmail(String email) {
        VerificationToken token = verificationTokenService.getByEmail(email);
        User user = userService.getByEmail(email);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), user.getFullName() ,"Thank you for signing up to RecruIT Management System, " +
                "please click on the below url to activate your account : " +
                "http://localhost:055117/api/auth/accountVerification/" + token.getToken(),""));
    }

    //@Transactional(readOnly = true)
    public User getCurrentUser() {
        Jwt principal = (Jwt) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userService.getByUsername(principal.getSubject());
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userService.getByUsername(username);
        user.setObjectState(Enum.ObjectState.ACTIVE);
        userService.update(user);
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken
                = new VerificationToken(token,user);

        verificationTokenService.create(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenService.getByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new ApiRequestException("Invalid Token")));
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        //Check Status
        switch (userService.getByUsername(loginRequest.getUsername()).getObjectState()){
            case FROZEN -> throw new ApiRequestException("The account have been frozen!");
            case TERMINATED -> throw new ApiRequestException("The account have been terminated! Please check with admin!");
            case CREATED -> throw new ApiRequestException("The account have not been activated yet! Please check your email!");
        }
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
//                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
//                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .logonUser(userService.getByUsername(loginRequest.getUsername()))
                .build();
    }

//    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
//        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
//        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
//        return AuthenticationResponse.builder()
//                .authenticationToken(token)
//                .refreshToken(refreshTokenRequest.getRefreshToken())
//                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
//                .logonUser(userService.getByUsername(refreshTokenRequest.getUsername()))
//                .build();
//    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}