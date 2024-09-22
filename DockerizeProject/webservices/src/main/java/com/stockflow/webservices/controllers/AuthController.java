package com.stockflow.webservices.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.stockflow.webservices.dto.AuthResponseDTO;
import com.stockflow.webservices.dto.LoginCredentialsDTO;
import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserAccountResponseDTO;
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
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody UserAccountRequestDTO user, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMessage = new HashMap<>();
                bindingResult.getFieldErrors().forEach(errorMap ->
                    errorMessage.put(errorMap.getField(), errorMap.getDefaultMessage())
                );

                return ResponseEntity.badRequest().body(errorMessage);
            }
            UserAccountResponseDTO registeredAccount = userServices.createUsers(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredAccount);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> loginCredentials(@Valid @RequestBody LoginCredentialsDTO credentials, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMessage = new HashMap<>();
                bindingResult.getFieldErrors().forEach(errorMap ->
                    errorMessage.put(errorMap.getField(), errorMap.getDefaultMessage())
                );

                return ResponseEntity.badRequest().body(errorMessage);
            }
            AuthResponseDTO user = authServices.authenticateUserCredentials(credentials);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

}
