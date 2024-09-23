package com.stockflow.webservices.services;

import java.util.List;
import java.util.Optional;

import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponseDto;
import com.stockflow.webservices.models.Users;

public interface UserServices {
    UserResponseDto createUsers(UserRequest newUsers);

    List<Users> getListOfUsers();

    Optional<Users> findUserById(Long userId);

    Users updateUserDetails(Users updatedUsers, Long userId);
    
    void deactivateUser(Long userId);
}
