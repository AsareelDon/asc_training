package com.stockflow.webservices.dto.mapper;

import com.stockflow.webservices.dto.AuthResponseDTO;
import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserResponseDto;
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

    public UserDetails userDetailsMapper(UserAccountRequestDTO  requestDto) {
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

    public UserResponseDto userDetailsResponseMapper(UserDetails user) {
        UserResponseDto responseDTO = new UserResponseDto();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setFirstname(user.getFirstName());
        responseDTO.setMiddlename(user.getMiddleName());
        responseDTO.setLastname(user.getLastName());
        responseDTO.setUserEmail(user.getAccounts().getUserName());

        return responseDTO;
    }

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
