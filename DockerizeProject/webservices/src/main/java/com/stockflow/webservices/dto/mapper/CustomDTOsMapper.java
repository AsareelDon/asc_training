package com.stockflow.webservices.dto.mapper;

import com.stockflow.webservices.dto.AuthResponse;
import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponse;
import com.stockflow.webservices.models.Accounts;
import com.stockflow.webservices.models.UserDetails;
import com.stockflow.webservices.services.PasswordServices;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class CustomDTOsMapper {
    
    private final PasswordServices passwordServices;

    public CustomDTOsMapper(PasswordServices passwordServices) {
        this.passwordServices = passwordServices;
    }

    public UserDetails userDetailsMapper(UserRequest  requestDto) {
        UserDetails user = new UserDetails();
        user.setFirstName(requestDto.getFirstname());
        user.setMiddleName(requestDto.getMiddlename());
        user.setLastName(requestDto.getLastname());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        Accounts userAccount = new Accounts();
        userAccount.setUser(user);
        userAccount.setUserName(requestDto.getUserEmail());
        userAccount.setUserPassword(passwordServices.passwordEncryption(requestDto.getUserPassword()));
        userAccount.setCreatedAt(LocalDateTime.now());
        userAccount.setUpdatedAt(LocalDateTime.now());

        user.setAccounts(userAccount);

        return user;
    }

    public UserResponse userDetailsResponseMapper(UserDetails user) {
        UserResponse responseDTO = new UserResponse();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setFirstname(user.getFirstName());
        responseDTO.setMiddlename(user.getMiddleName());
        responseDTO.setLastname(user.getLastName());
        responseDTO.setUserEmail(user.getAccounts().getUserName());

        return responseDTO;
    }

    public AuthResponse authResponseMapper(Accounts userAccounts) {
        AuthResponse responseDTO = new AuthResponse();
        responseDTO.setUserId(userAccounts.getUser().getUserId());
        responseDTO.setFirstname(userAccounts.getUser().getFirstName());
        responseDTO.setMiddlename(userAccounts.getUser().getMiddleName());
        responseDTO.setLastname(userAccounts.getUser().getLastName());
        responseDTO.setUserEmail(userAccounts.getUserName());

        return responseDTO;
    }
}
