package com.stockflow.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.webservices.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
