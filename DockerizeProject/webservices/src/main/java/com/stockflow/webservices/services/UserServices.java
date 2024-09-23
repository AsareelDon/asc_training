package com.stockflow.webservices.services;

import java.util.List;
import java.util.Optional;

import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserResponseDto;
import com.stockflow.webservices.models.UserDetails;

public interface UserServices {
    UserResponseDto createUsers(UserAccountRequestDTO newUsers);

    List<UserDetails> getListOfUsers();

    Optional<UserDetails> findUserById(Long userId);

    UserDetails updateUserDetails(UserDetails updatedUsers, Long userId);
    
    void deactivateUser(Long userId);
}
