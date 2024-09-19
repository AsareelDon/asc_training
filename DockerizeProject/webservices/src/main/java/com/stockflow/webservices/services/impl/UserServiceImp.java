package com.stockflow.webservices.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockflow.webservices.models.UserDetails;
import com.stockflow.webservices.repository.UserRepository;
import com.stockflow.webservices.services.UserServices;

@Service
public class UserServiceImp implements UserServices {

    private final UserRepository userRepository;
    
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails createUsers(UserDetails newUsers) {
        try {
            return userRepository.save(newUsers);
        } catch (Exception e) {
            throw new Error("Failed to create User");
        }
    }

    @Override
    public List<UserDetails> getListOfUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new Error("Failed to retrieve Users");
        }
    }

    @Override
    public Optional<UserDetails> findUserById(Long userId) {
        try {
            return userRepository.findById(userId);
        } catch (Exception e) {
            throw new Error("Failed to retrieve User");
        }
    }

    @Override
    public UserDetails updateUserDetails(UserDetails updatedUsers, Long userId) {
        try {
            updatedUsers.setUserId(userId);
            return userRepository.save(updatedUsers);
        } catch (Exception e) {
            throw new Error("Failed to update User");
        }
    }

    @Override
    public void deactivateUser(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new Error("Failed to update User");
        }
    }

    
}
