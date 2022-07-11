package com.recruit.recruitms.controller;

import com.recruit.recruitms.dto.request.LoginRequest;
import com.recruit.recruitms.dto.request.RefreshTokenRequest;
import com.recruit.recruitms.dto.request.RegisterRequest;
import com.recruit.recruitms.dto.response.AuthenticationResponse;
import com.recruit.recruitms.security.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    //private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest)  throws MessagingException{
        authService.signup(registerRequest);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("accountVerification/resend/{email}")
    public ResponseEntity<String> resendVerificationEmail (@PathVariable String email)  throws MessagingException{
        authService.resendVerificationEmail(email);
        return new ResponseEntity<>("Verification Email sent Successfully", OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
//
//    @PostMapping("/refresh/token")
//    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
//        return authService.refreshToken(refreshTokenRequest);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
//        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
//        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
//    }
}
