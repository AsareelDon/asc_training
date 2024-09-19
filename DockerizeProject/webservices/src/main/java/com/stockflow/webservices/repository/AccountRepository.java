package com.stockflow.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.webservices.models.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
