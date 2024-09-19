package com.stockflow.webservices.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAccountRequestDTO {
    private Long userId;
    @NotBlank(message = "First name is required.")
    private String firstname;
    private String middlename;
    @NotBlank(message = "Last name is required.")
    private String lastname;
    @NotBlank(message = "Email address is required.")
    private String userEmail;
    @NotBlank(message = "Password is required.")
    private String userPassword;
}
