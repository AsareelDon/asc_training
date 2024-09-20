package com.stockflow.webservices.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "password.hashing.algo.argon2")
@Data
public class PasswordConfig {
    private int type;
    private int hashLength;
    private int saltLength;
    private int iterations;
    private int memory;
    private int parallelism;
}
