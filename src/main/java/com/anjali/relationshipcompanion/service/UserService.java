package com.anjali.relationshipcompanion.service;

import com.anjali.relationshipcompanion.exception.InvalidCredentialsException;
import com.anjali.relationshipcompanion.dto.UserLoginRequest;
import com.anjali.relationshipcompanion.dto.UserRegistrationRequest;
import com.anjali.relationshipcompanion.exception.EmailAlreadyExistsException;
import com.anjali.relationshipcompanion.model.User;
import com.anjali.relationshipcompanion.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // =========================
    // REGISTER USER
    // =========================

    public User registerUser(UserRegistrationRequest request) {

        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Never store the plain-text password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setGender(request.getGender());
        user.setDateOfBirth(request.getDateOfBirth());

        return userRepository.save(user);
    }

    // =========================
    // LOGIN USER
    // =========================

    public User loginUser(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new InvalidCredentialsException("Invalid email or password");
        }

        return user;
    }
}