package com.hotel.backend_hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hotel.backend_hotel.entity.User;

//JpaRepository gives free methods: save(), findAll(), findById()
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//find user by email - used during login
Optional<User> findByEmail(String email);
//check if email exists - used during register
boolean existsByEmail(String email);
}

