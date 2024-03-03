package com.cp_backend.controller;

import com.cp_backend.entity.User;
import com.cp_backend.repository.UserRepository;
import com.cp_backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        List<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (!existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body("Email is already registered.");
        }
        String registrationStatus = userService.registerUser(user);
        return ResponseEntity.ok(registrationStatus);
    }

}
