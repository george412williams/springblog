package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    //dependency inj
    private UserRepository users;
        //later change to userrepository from users
    private PasswordEncoder passwordEncoder;
        //spring comes w own pw encoder

    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }
        //commented out to check ______
    //end dep

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        //hashing, short way from java iii
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }
}
