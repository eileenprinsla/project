package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller  
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
    // Show signup form
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";  // Will look for signup.html in /src/main/resources/templates
    }

   
    @PostMapping("/success")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);  // Save the user to the database
        return "success";  // Redirect to success page after signup
    }
}
