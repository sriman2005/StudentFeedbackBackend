package com.studentfeedback.service;
import com.studentfeedback.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User registerUser(User user);
    User authenticateUser(String username, String password);
    Page<User> getAllUsers(Pageable pageable);
    void deleteUser(Long userId);
    User updateUserStatus(Long userId, boolean enabled);
    User updateUserProfile(Long userId, User userDetails);
    void changePassword(Long userId, String currentPassword, String newPassword);
    
}