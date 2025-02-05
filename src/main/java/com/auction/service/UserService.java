package com.auction.service;

import com.auction.model.User;
import com.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;

// Register a new user (Admin or Customer)
public User register(User user) {
return userRepository.save(user);
}

// Find user by username for login purposes
public User findByUsername(String username) {
return userRepository.findByUsername(username);
}
}
