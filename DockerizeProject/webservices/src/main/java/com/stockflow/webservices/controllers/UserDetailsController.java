package com.stockflow.webservices.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.webservices.models.UserDetails;
import com.stockflow.webservices.services.UserDetailsServices;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1")
public class UserDetailsController {

    private final UserDetailsServices userServices;

    public UserDetailsController(UserDetailsServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("createUsers")
    public UserDetails createNewUser(@RequestBody UserDetails newUsers) {
        return userServices.createUsers(newUsers);
    }

    @GetMapping("getAllUsers")
    public List<UserDetails> getAllUsers() {
        return userServices.getListOfUsers();
    }
    
    @GetMapping("getUser/{userId}")
    public Optional<UserDetails> getUserById(@PathVariable("userId") Long userId) {
        return userServices.findUserById(userId);
    }

    @PutMapping("updateUser/{userId}")
    public UserDetails updateUser(@PathVariable Long userId, @RequestBody UserDetails updatedUser) {
        return userServices.updateUserDetails(updatedUser, userId);
    }

    @DeleteMapping("deactivvateUser/{userid}")
    public void deactivateUser(@PathVariable("userId") Long userId) {
        userServices.deactivateUser(userId);
    }
}
