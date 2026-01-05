package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

/**
 * Repository for saving new and retrieving existing {@link User}s from DB
 *
 */
public interface UserRepository extends JpaRepository<User, String> {
}