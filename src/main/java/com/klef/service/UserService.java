package com.klef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.model.User;
import com.klef.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // ✅ REGISTER
    public User register(User user) {
        return repo.save(user);
    }

    // ✅ LOGIN (SAFE - NO 500 ERROR)
    public User login(String email, String password) {

        User user = repo.findByEmail(email);

        if (user != null) {
            String dbPassword = user.getPassword();

            if (dbPassword != null && dbPassword.equals(password)) {
                return user;
            }
        }

        return null;
    }

    // ✅ PROFILE
    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }
}