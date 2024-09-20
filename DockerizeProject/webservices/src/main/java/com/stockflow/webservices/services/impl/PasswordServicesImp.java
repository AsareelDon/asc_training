package com.stockflow.webservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.webservices.configs.PasswordConfig;
import com.stockflow.webservices.services.PasswordServices;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class PasswordServicesImp implements PasswordServices {

    private PasswordConfig passwordConfig;

    @Autowired
    public void PasswordServicesImpl(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    @Override
    public String passwordEncryption(String userPassword) {
        Argon2 argon2 = getArgon2Instance();
        try {
            return argon2.hash(
                passwordConfig.getIterations(),
                passwordConfig.getMemory(),
                passwordConfig.getParallelism(),
                userPassword.toCharArray()
            );
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error during password encryption: " + e.getMessage());
            throw new RuntimeException("Password encryption failed", e);
        }
    }

    /**
     * Get instance of Argon2Factory to determine argon2 types
     * @return Argon2Factory created intances
     */
    private Argon2 getArgon2Instance() {
        Argon2Factory.Argon2Types argon2Types = Argon2Factory.Argon2Types.ARGON2d;

        switch (passwordConfig.getType()) {
            case 1:
                argon2Types = Argon2Factory.Argon2Types.ARGON2i;
                break;
            case 2:
                argon2Types = Argon2Factory.Argon2Types.ARGON2id;
                break;
            default:
                break;
        }
        return Argon2Factory.create(
            argon2Types,
            passwordConfig.getSaltLength(),
            passwordConfig.getHashLength()
        );
    }

}
