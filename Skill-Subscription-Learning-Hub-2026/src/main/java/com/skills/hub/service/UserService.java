package com.skills.hub.service.impl;

import com.skills.hub.model.User;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    // Optional: Inject BCryptPasswordEncoder here if you are using Spring Security
    // private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        // 1. Validate input data
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User data, email, and password cannot be null");
        }

        // 2. Check if a user already exists with the same email
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email is already registered: " + user.getEmail());
        }

        // 3. Security Best Practice: Hash the password before saving
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 4. Save and return the new user
        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        // 1. Validate inputs
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password are required");
        }

        // 2. Look up the user by email
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        // 3. Verify the password
        // If using Spring Security: if (!passwordEncoder.matches(password, user.getPassword()))
        if (!user.getPassword().equals(password)) { 
            throw new IllegalArgumentException("Invalid email or password");
        }

        // 4. Return user on successful authentication
        return user;
    }
}
