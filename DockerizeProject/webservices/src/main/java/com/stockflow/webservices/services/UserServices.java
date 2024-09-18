package com.stockflow.webservices.services;

import java.util.List;
import java.util.Optional;

import com.stockflow.webservices.models.Users;

public interface UserServices {
    Users createUsers(Users newUsers);
    List<Users> getListOfUsers();
    Optional<Users> findUserById(Long userId);
    Users updateUserDetails(Users updatedUsers, Long userId);
    void deactivateUser(Long userId);
}
