package com.stockflow.webservices.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginCredentialsDTO {
    @NotBlank(message = "Email address is required.")
    private String userEmail;
    @NotBlank(message = "Password is required.")
    private String userPassword;
}
