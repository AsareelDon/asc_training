package com.stockflow.webservices.dto.mapper;

import com.stockflow.webservices.dto.AuthResponse;
import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponseDto;
import com.stockflow.webservices.models.Accounts;
import com.stockflow.webservices.models.Roles;
import com.stockflow.webservices.models.Users;
import com.stockflow.webservices.services.PasswordServices;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class CustomDTOsMapper {
    
    private final PasswordServices passwordServices;

    public CustomDTOsMapper(PasswordServices passwordServices) {
        this.passwordServices = passwordServices;
    }

    public Users userDetailsMapper(UserRequest requestDto) {
        Users user = new Users();
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
        userAccount.setAccountRole(Roles.USER);

        user.setAccounts(userAccount);

        return user;
    }

    public UserResponseDto userDetailsResponseMapper(Users user) {
        UserResponseDto responseDTO = new UserResponseDto();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setFirstname(user.getFirstName());
        responseDTO.setMiddlename(user.getMiddleName());
        responseDTO.setLastname(user.getLastName());
        responseDTO.setUserEmail(user.getAccounts().getUsername());

        return responseDTO;
    }

    public AuthResponse authResponseMapper(Accounts userAccounts) {
        AuthResponse responseDTO = new AuthResponse();
        responseDTO.setUserId(userAccounts.getUser().getUserId());
        responseDTO.setFirstname(userAccounts.getUser().getFirstName());
        responseDTO.setMiddlename(userAccounts.getUser().getMiddleName());
        responseDTO.setLastname(userAccounts.getUser().getLastName());
        responseDTO.setUserEmail(userAccounts.getUsername());
        responseDTO.setAccountRoles(userAccounts.getAccountRole());
        
        return responseDTO;
    }
}
