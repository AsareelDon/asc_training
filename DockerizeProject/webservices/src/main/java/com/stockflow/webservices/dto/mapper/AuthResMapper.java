package com.stockflow.webservices.dto.mapper;

import org.springframework.stereotype.Component;

import com.stockflow.webservices.dto.AuthResponseDTO;
import com.stockflow.webservices.models.Accounts;

@Component
public class AuthResMapper {

    public AuthResponseDTO authResponseMapper(Accounts userAccounts) {
        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setUserId(userAccounts.getUser().getUserId());
        responseDTO.setFirstname(userAccounts.getUser().getFirstName());
        responseDTO.setMiddlename(userAccounts.getUser().getMiddleName());
        responseDTO.setLastname(userAccounts.getUser().getLastName());
        responseDTO.setUserEmail(userAccounts.getUserName());

        return responseDTO;
    }
}
