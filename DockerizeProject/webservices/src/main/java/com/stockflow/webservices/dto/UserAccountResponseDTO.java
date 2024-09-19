package com.stockflow.webservices.dto;

import lombok.Data;

@Data
public class UserAccountResponseDTO {
    private Long userId;
    private String firstname;
    private String middlename;
    private String lastname;
    private String userEmail;
}
