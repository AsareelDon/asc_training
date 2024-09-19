package com.stockflow.webservices.dto.mapper;

import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserAccountResponseDTO;
import com.stockflow.webservices.models.Accounts;
import com.stockflow.webservices.models.UserDetails;
import java.time.LocalDateTime;

public class UserMapper {

    public static UserDetails userDetailsMapper(UserAccountRequestDTO  requestDto) {
        UserDetails user = new UserDetails();
        user.setFristName(requestDto.getFirstname());
        user.setMiddleName(requestDto.getMiddlename());
        user.setLastName(requestDto.getLastname());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        Accounts userAccount = new Accounts();
        userAccount.setUser(user);
        userAccount.setUserName(requestDto.getUserEmail());
        userAccount.setUserPassword(requestDto.getUserPassword());
        userAccount.setCreatedAt(LocalDateTime.now());
        userAccount.setUpdatedAt(LocalDateTime.now());

        user.setAccounts(userAccount);

        return user;
    }

    public static UserAccountResponseDTO userDetailsResponseMapper(UserDetails user) {
        UserAccountResponseDTO responseDTO = new UserAccountResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setFirstname(user.getFristName());
        responseDTO.setMiddlename(user.getMiddleName());
        responseDTO.setLastname(user.getLastName());
        responseDTO.setUserEmail(user.getAccounts().getUserName());

        return responseDTO;
    }
}
