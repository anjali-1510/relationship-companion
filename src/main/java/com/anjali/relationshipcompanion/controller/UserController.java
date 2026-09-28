package com.anjali.relationshipcompanion.controller;

import com.anjali.relationshipcompanion.dto.UserLoginRequest;
import com.anjali.relationshipcompanion.dto.UserRegistrationRequest;
import com.anjali.relationshipcompanion.dto.UserResponse;
import com.anjali.relationshipcompanion.model.User;
import com.anjali.relationshipcompanion.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // =========================
    // REGISTER
    // =========================

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(
            @Valid @RequestBody UserRegistrationRequest request) {

        User registeredUser = userService.registerUser(request);

        UserResponse response = new UserResponse(
                registeredUser.getId(),
                registeredUser.getName(),
                registeredUser.getEmail(),
                registeredUser.getGender(),
                registeredUser.getDateOfBirth()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // =========================
    // LOGIN
    // =========================

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(
            @RequestBody UserLoginRequest request) {

        User loggedInUser = userService.loginUser(request);

        UserResponse response = new UserResponse(
                loggedInUser.getId(),
                loggedInUser.getName(),
                loggedInUser.getEmail(),
                loggedInUser.getGender(),
                loggedInUser.getDateOfBirth()
        );

        return ResponseEntity.ok(response);
    }
}