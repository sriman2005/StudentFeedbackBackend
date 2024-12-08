package com.studentfeedback.service.impl;
import com.studentfeedback.model.User;
import com.studentfeedback.model.UserRole;
import com.studentfeedback.repository.UserRepository;
import com.studentfeedback.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        user.setRole(UserRole.STUDENT);
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        
        return user;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUserStatus(Long userId, boolean enabled) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        // Add a field to User model for enabled status if not already present
        return userRepository.save(user);
    }
    @Override
    public User updateUserProfile(Long userId, User userDetails) {
        User existingUser = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the new username or email is already taken by another user
        if (!existingUser.getUsername().equals(userDetails.getUsername()) 
            && userRepository.existsByUsername(userDetails.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (!existingUser.getEmail().equals(userDetails.getEmail()) 
            && userRepository.existsByEmail(userDetails.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Update user details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPhoneNumber(userDetails.getPhoneNumber());

        return userRepository.save(existingUser);
    }
    @Override
    public void changePassword(Long userId, String currentPassword, String newPassword) {
        // Validate input
        if (newPassword == null || newPassword.length() < 8) {
            throw new RuntimeException("New password must be at least 8 characters long");
        }

        // Find the user
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Verify current password
        if (!user.getPassword().equals(currentPassword)) {
            throw new RuntimeException("Current password is incorrect");
        }

        // Update password
        user.setPassword(newPassword);
        userRepository.save(user);
    }
    


}