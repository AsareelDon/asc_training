package com.stockflow.webservices.services;

import java.util.List;
import java.util.Optional;

import com.stockflow.webservices.dto.UserRequest;
import com.stockflow.webservices.dto.UserResponse;
import com.stockflow.webservices.models.UserDetails;

public interface UserServices {
    UserResponse createUsers(UserRequest newUsers);

    List<UserDetails> getListOfUsers();

    Optional<UserDetails> findUserById(Long userId);

    UserDetails updateUserDetails(UserDetails updatedUsers, Long userId);
    
    void deactivateUser(Long userId);
}
