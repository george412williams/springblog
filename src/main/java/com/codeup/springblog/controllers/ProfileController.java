package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping("/profile/{username}")
    public String viewProfile(@PathVariable String username, Model model) {
        model.addAttribute("user", username);
        //first is ... second coming from path var, user is used to call
        return "profile";
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "profile";
    }


}
