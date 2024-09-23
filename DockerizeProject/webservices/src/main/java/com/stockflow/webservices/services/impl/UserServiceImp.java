package com.stockflow.webservices.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockflow.webservices.dto.UserAccountRequestDTO;
import com.stockflow.webservices.dto.UserResponseDto;
import com.stockflow.webservices.dto.mapper.CustomDTOsMapper;
import com.stockflow.webservices.models.UserDetails;
import com.stockflow.webservices.repository.UserRepository;
import com.stockflow.webservices.services.UserServices;

@Service
public class UserServiceImp implements UserServices {

    private final UserRepository userRepository;

    private final CustomDTOsMapper userMapper;
    
    public UserServiceImp(UserRepository userRepository, CustomDTOsMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto createUsers(UserAccountRequestDTO userAccountDTO) {
        // Aggregating Data from Multiple Sources UserDetails and Accounts
        // Mapped resonse from responseDTO
        UserDetails user = userMapper.userDetailsMapper(userAccountDTO);
        user = userRepository.save(user);
        userAccountDTO.setUserId(user.getUserId());
        UserResponseDto responseDTO = userMapper.userDetailsResponseMapper(user);

        return responseDTO;
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
