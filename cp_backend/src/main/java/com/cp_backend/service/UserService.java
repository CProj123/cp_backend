package com.cp_backend.service;

import com.cp_backend.entity.User;
import com.cp_backend.repository.UserRepository;

import java.util.List;

public interface UserService {
    String registerUser(User user);
    List<User> findbyUserEmail(String userEmail);
}
