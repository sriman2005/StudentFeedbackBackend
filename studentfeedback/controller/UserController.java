package com.studentfeedback.controller;

import com.studentfeedback.model.User;
import com.studentfeedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/status")
    public ResponseEntity<User> updateUserStatus(
        @PathVariable Long userId, 
        @RequestBody boolean enabled
    ) {
        User updatedUser = userService.updateUserStatus(userId, enabled);
        return ResponseEntity.ok(updatedUser);
    }
    @PutMapping("/profile/{userId}")
    public ResponseEntity<User> updateUserProfile(
        @PathVariable Long userId, 
        @RequestBody User userDetails
    ) {
        try {
            User updatedUser = userService.updateUserProfile(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            // Convert runtime exceptions to appropriate HTTP responses
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                e.getMessage(), 
                e
            );
        }
}
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(
        @RequestBody PasswordChangeRequest passwordChangeRequest
    ) {
        try {
            userService.changePassword(
                passwordChangeRequest.getUserId(),
                passwordChangeRequest.getCurrentPassword(),
                passwordChangeRequest.getNewPassword()
            );
            return ResponseEntity.ok("Password changed successfully");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                e.getMessage(), 
                e
            );
        }
    }
    public static class PasswordChangeRequest {
        private Long userId;
        private String currentPassword;
        private String newPassword;

        // Getters and setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getCurrentPassword() {
            return currentPassword;
        }

        public void setCurrentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
    

}