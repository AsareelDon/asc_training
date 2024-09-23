package com.stockflow.webservices.services;

import com.stockflow.webservices.dto.AuthResponse;
import com.stockflow.webservices.dto.LoginCredentials;

public interface AuthServices {
    AuthResponse authenticateUserCredentials(LoginCredentials credentialsDTO);
}
