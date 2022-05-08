//package com.recruit.recruitms.controller;
//
//import com.recruit.recruitms.dto.RegisterRequest;
//import com.recruit.recruitms.dto.Response;
//import com.recruit.recruitms.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//import static java.time.LocalDateTime.now;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthService _authService;
//
//    @Autowired
//    public AuthController(AuthService _authService) {
//        this._authService = _authService;
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<Response> signUp(@RequestBody RegisterRequest registerRequest){
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(Map.of("signup", _authService.signUp(registerRequest)))
//                        .message("User Registered Successfully")
//                        .status(HttpStatus.OK)
//                        .statusCode(HttpStatus.OK.value())
//                        .build()
//        );
//    }
//
//}
