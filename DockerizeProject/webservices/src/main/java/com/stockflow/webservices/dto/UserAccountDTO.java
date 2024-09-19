package com.stockflow.webservices.dto;

import lombok.Data;

@Data
public class UserAccountDTO {
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String userEmail;
    private String userPassword;
}
