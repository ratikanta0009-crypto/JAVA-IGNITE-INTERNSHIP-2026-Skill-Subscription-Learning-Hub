package com.skills.hub.controller;

import com.skills.hub.model.User;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
=========================================================
WHAT IS THIS FILE?
Handles user actions like register and login
=========================================================
*/
@Controller
public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Display registration page
     */
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        boolean registered = userService.registerUser(user);

        if (registered) {
            return "redirect:/login";
        }

        return "register";
    }

    /**
     * Display login page
     */
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    /**
     * Authenticate user
     */
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {

        User loggedInUser = userService.login(email, password);

        if (loggedInUser != null) {
            return "redirect:/packs";
        }

        return "login";
    }

    public UserService getUserService() {
        return userService;
    }
}
