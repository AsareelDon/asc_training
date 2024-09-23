package com.stockflow.webservices.services.impl;

import org.springframework.stereotype.Service;

import com.stockflow.webservices.dto.AuthResponse;
import com.stockflow.webservices.dto.LoginCredentials;
import com.stockflow.webservices.dto.mapper.CustomDTOsMapper;
import com.stockflow.webservices.models.Accounts;
import com.stockflow.webservices.repository.AccountRepository;
import com.stockflow.webservices.services.AuthServices;
import com.stockflow.webservices.services.PasswordServices;

@Service
public class AuthServiceImpl implements AuthServices {

    private final CustomDTOsMapper responseMapper;
    private final AccountRepository accountRepository;
    private final PasswordServices passwordServices;
    
    public AuthServiceImpl(CustomDTOsMapper responseMapper, AccountRepository accountRepository, PasswordServices passwordServices) {
        this.responseMapper = responseMapper;
        this.accountRepository = accountRepository;
        this.passwordServices = passwordServices;
    }

    @Override
    public AuthResponse authenticateUserCredentials(LoginCredentials credentialsDTO) {
        Accounts userAccount = accountRepository.findByUserName(credentialsDTO.getUserEmail());
        if (userAccount == null) {
            throw new RuntimeException("Username doesn't exist in our record");
        }
        boolean isPasswordValid = passwordServices.validateUserPassword(userAccount.getUserPassword(), credentialsDTO.getUserPassword());
        if (!isPasswordValid) {
            throw new RuntimeException("Invalid Password!");
        }
        AuthResponse responseDTO = responseMapper.authResponseMapper(userAccount);
        return responseDTO;
    }

}
