package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Response;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(path="api/user")
public class UserController {

    private final UserService _userService;

    @Autowired
    public UserController(UserService service) {
        this._userService = service;
    }

    @GetMapping
    public ResponseEntity<Response> getAllUsers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("users",_userService.getAll()))
                        .message("Users Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/active")
    public ResponseEntity<Response> getActiveUsers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("users", _userService.getActive()))
                        .message("Active Users Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") UUID id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user", _userService.getById(id)))
                        .message("User Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path="/username/{username}")
    public ResponseEntity<Response> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user", _userService.getByUsername(username)))
                        .message("User Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> registerUser(@RequestBody User user){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user", _userService.create(user)))
                        .message("User Created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @PutMapping
    public ResponseEntity<Response> updateUser(@RequestBody User user){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user", _userService.update(user)))
                        .message("User Created")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );

    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") UUID id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", _userService.delete(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
