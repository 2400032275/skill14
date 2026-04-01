package com.klef.repository;

import com.klef.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ✅ REQUIRED METHOD
    User findByEmail(String email);
}