package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/user")
public class UserController {

    private final UserService _userService;

    @Autowired
    public UserController(UserService service) {
        this._userService = service;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return _userService.getAllUsers();
    }

    @GetMapping("/active")
    public List<User> getActiveUsers(){
        return _userService.getActiveUsers();
    }

    @GetMapping(path="/id/{id}")
    public User getUser(@PathVariable("id") UUID id){
        return _userService.getUserById(id);
    }

    @GetMapping(path="/username/{username}")
    public User getUser(@PathVariable("username") String username){
        return _userService.getUserByUsername(username);
    }

    @PostMapping("/add")
    public void registerUser(@RequestBody User user){
        _userService.addNewUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        _userService.updateUser(user);
    }

    @DeleteMapping(path="{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        _userService.deleteUser(id);
    }

}
