package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    private final UserService _userService;

    @Autowired
    public UserController(UserService service) {
        this._userService = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(_userService.getAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<User>> getActiveUsers(){
        return ResponseEntity.ok(_userService.getActive());
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") UUID id){
        return ResponseEntity.ok(_userService.getById(id));
    }

    @GetMapping(path="/username/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok(_userService.getByUsername(username));
    }

    //@PostMapping("/{updater}")
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(_userService.create(user));
    }

    //@PutMapping("/{updater}")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(_userService.update(user));
    }

    @DeleteMapping(path="{id}")
    public boolean deleteUser(@PathVariable("id") UUID id){
        return _userService.delete(id);
    }

}
