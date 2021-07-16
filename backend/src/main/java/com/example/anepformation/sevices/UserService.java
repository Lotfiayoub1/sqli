package com.example.anepformation.sevices;

import com.example.anepformation.model.User;
import com.example.anepformation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> registerUser(User user) {
        if (user.getUserType() == null ||
                user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        User user1;
        User savedEntity;
        switch (user.getUserType()) {
            case former :
                user1 = new User(null,user.getEmail_personnel(),
                        user.getEmail_professional(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPhone_personnel(),
                        user.getPhone_professional(),
                        0,
                        user.getUserType());
                savedEntity = userRepository.save(user1);
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(savedEntity);
    }
}
