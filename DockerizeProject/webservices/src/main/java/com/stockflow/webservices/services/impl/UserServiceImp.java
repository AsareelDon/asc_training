package com.stockflow.webservices.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserAccountResponseDTO;
import com.stockflow.webservices.models.Accounts;
import com.stockflow.webservices.models.UserDetails;
import com.stockflow.webservices.repository.UserRepository;
import com.stockflow.webservices.services.UserServices;
import java.time.LocalDateTime;

@Service
public class UserServiceImp implements UserServices {

    private final UserRepository userRepository;
    
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAccountResponseDTO createUsers(UserAccountRequestDTO userAccountDTO) {
        try {
            UserDetails user = new UserDetails();
            user.setFristName(userAccountDTO.getFirstname());
            user.setMiddleName(userAccountDTO.getMiddlename());
            user.setLastName(userAccountDTO.getLastname());
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());

            Accounts userAccount = new Accounts();
            userAccount.setUser(user);
            userAccount.setUserName(userAccountDTO.getUserEmail());
            userAccount.setUserPassword(userAccountDTO.getUserPassword());
            userAccount.setCreatedAt(LocalDateTime.now());
            userAccount.setUpdatedAt(LocalDateTime.now());

            user.setAccounts(userAccount);

            user = userRepository.save(user);

            userAccountDTO.setUserId(user.getUserId());

            UserAccountResponseDTO responseDTO = new UserAccountResponseDTO();
            responseDTO.setUserId(user.getUserId());
            responseDTO.setFirstname(user.getFristName());
            responseDTO.setMiddlename(user.getMiddleName());
            responseDTO.setLastname(user.getLastName());
            responseDTO.setUserEmail(userAccount.getUserName());

            return responseDTO;
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
