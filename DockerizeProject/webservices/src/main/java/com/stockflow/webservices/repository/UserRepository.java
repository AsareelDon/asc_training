package com.stockflow.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.webservices.models.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
}
