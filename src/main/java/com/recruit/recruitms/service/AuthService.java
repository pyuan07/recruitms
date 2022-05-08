//package com.recruit.recruitms.service;
//
//import com.recruit.recruitms.dto.RegisterRequest;
//import com.recruit.recruitms.entity.NotificationEmail;
//import com.recruit.recruitms.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//public class AuthService {
//
//    private final UserService _userService;
//    private final MailService _mailService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthService(UserService _userService, MailService _mailService) {
//        this._userService = _userService;
//        this._mailService = _mailService;
//    }
//
//
//
//    @Transactional
//    public boolean signUp(RegisterRequest registerRequest){
//        User user= new User();
//        user.setUsername(registerRequest.username);
//        user.setEmail(registerRequest.email);
//        user.setPassword(passwordEncoder.encode(registerRequest.password));
//
//        _userService.create(user);
//
//        //Mail Validation
//        _mailService.sendMail(new NotificationEmail("Please Activate your Account",
//                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
//                "please click on the below url to activate your account : " +
//                "http://localhost:8080/api/auth/accountVerification/" + user.getId()));
//
//        return true;
//    }
//
//}
