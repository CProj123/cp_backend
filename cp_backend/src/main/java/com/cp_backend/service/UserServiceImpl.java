package com.cp_backend.service;

import com.cp_backend.entity.User;
import com.cp_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public String registerUser(User user) {
        userRepository.save(user);
        return "User Registered";
    }
    @Override
    public List<User> findbyUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }
}
