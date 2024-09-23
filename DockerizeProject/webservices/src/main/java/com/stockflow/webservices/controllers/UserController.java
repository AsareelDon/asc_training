package com.stockflow.webservices.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponseDto;
import com.stockflow.webservices.models.Users;
import com.stockflow.webservices.services.UserServices;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("createUsers")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody UserRequest users, BindingResult bindResult) {
        try {
            if (bindResult.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                bindResult.getFieldErrors().forEach(error -> 
                    errors.put(error.getField(), 
                    error.getDefaultMessage())
                );
    
                return ResponseEntity.badRequest().body(errors);
            }
            UserResponseDto createdUsers = userServices.createUsers(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("getAllUsers")
    public List<Users> getAllUsers() {
        return userServices.getListOfUsers();
    }
    
    @GetMapping("getUser/{userId}")
    public Optional<Users> getUserById(@PathVariable("userId") Long userId) {
        return userServices.findUserById(userId);
    }

    @PutMapping("updateUser/{userId}")
    public Users updateUser(@PathVariable Long userId, @RequestBody Users updatedUser) {
        return userServices.updateUserDetails(updatedUser, userId);
    }

    @DeleteMapping("deactivvateUser/{userid}")
    public void deactivateUser(@PathVariable("userId") Long userId) {
        userServices.deactivateUser(userId);
    }
}
