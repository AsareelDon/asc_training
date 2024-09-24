package com.stockflow.webservices.dto;

import com.stockflow.webservices.models.Roles;

import lombok.Data;

@Data
public class AuthResponse {
    private Long userId;
    private String firstname;
    private String middlename;
    private String lastname;
    private String userEmail;
    private Roles accountRoles;
}
