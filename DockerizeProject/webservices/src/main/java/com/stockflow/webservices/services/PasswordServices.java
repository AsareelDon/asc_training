package com.stockflow.webservices.services;

public interface PasswordServices {
    public String passwordEncryption(String userPassword);

    public boolean validateUserPassword(String hash, String userPassword);
}
