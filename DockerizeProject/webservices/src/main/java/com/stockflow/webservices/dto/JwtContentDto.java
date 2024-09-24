package com.stockflow.webservices.dto;

import com.stockflow.webservices.models.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtContentDto {
    private Long userId;
    private String userEmail;
    private Roles accountRole;
}
