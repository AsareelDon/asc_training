package com.stockflow.webservices.services;

import com.stockflow.webservices.dto.AuthResponseDTO;
import com.stockflow.webservices.dto.LoginCredentialsDTO;

public interface AuthServices {
    AuthResponseDTO authenticateUserCredentials(LoginCredentialsDTO credentialsDTO);
}
