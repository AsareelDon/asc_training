package com.stockflow.webservices.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.stockflow.webservices.dto.AuthResponse;
import com.stockflow.webservices.dto.LoginCredentials;
import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponse;
import com.stockflow.webservices.services.AuthServices;
import com.stockflow.webservices.services.UserServices;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {

    private final UserServices userServices;
    private final AuthServices authServices;

    public AuthController(UserServices userServices, AuthServices authServices) {
        this.userServices = userServices;
        this.authServices = authServices;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody UserRequest user, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMessage = new HashMap<>();
                bindingResult.getFieldErrors().forEach(errorMap ->
                    errorMessage.put(errorMap.getField(), errorMap.getDefaultMessage())
                );

                return ResponseEntity.badRequest().body(errorMessage);
            }
            UserResponse registeredAccount = userServices.createUsers(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredAccount);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> loginCredentials(@Valid @RequestBody LoginCredentials credentials, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMessage = new HashMap<>();
                bindingResult.getFieldErrors().forEach(errorMap ->
                    errorMessage.put(errorMap.getField(), errorMap.getDefaultMessage())
                );

                return ResponseEntity.badRequest().body(errorMessage);
            }
            AuthResponse user = authServices.authenticateUserCredentials(credentials);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

}
