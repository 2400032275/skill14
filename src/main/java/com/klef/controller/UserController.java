package com.klef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.model.User;
import com.klef.repository.UserRepository;
import com.klef.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request){

        User user = repo.findByEmail(request.getEmail());

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User not found");
        }

        if(!user.getPassword().equals(request.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password");
        }

        return ResponseEntity.ok(user);
    }
}