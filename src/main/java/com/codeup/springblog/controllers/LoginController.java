package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String viewLoginForm() {
        return "login";
    }

    @PostMapping("/profile")
    public String viewLoginInfo(@RequestParam(name = "username") String username, @RequestParam(name="password") String password, Model model) {
        ArrayList<String> ads = new ArrayList<String>();
        //db stuff in the next lesson, making a fake list to add to
        boolean isLoggedIn = true;
        //for loginsecurity

        ads.add("Ad 1");
        ads.add("Ad 2");
        ads.add("Ad 3");
        //to make accessible add to model
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("ads", ads);
            //got ads list and sending over
        model.addAttribute("isLoggedIn", isLoggedIn);


        return "profile";
    }

}
