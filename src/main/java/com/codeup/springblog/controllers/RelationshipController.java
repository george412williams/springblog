package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RelationshipController {

    //dependency
    //could create a comment repository, but w just ad repos right now:
    private final AdRepository adsDao;

    public RelationshipController(AdRepository adsDao){
        this.adsDao = adsDao;
    }

    //view all ads comments as JSON
    @GetMapping("/rel/ads")
    @ResponseBody
    public List<Ad> returnAllAds(){
        //remember to inject dependency

        //json view logic
        List<Ad> ads = adsDao.findAll();
        String content = ads.get(0).getComments().get(0).getContent();
            //this demonstrates how to get the info back out of ads wo digging into in the ads controller
        System.out.println(content);
            //the list allows for digging and grabbing of specific content in the comment, souting string only that is part of that comments of that said record
        //next will show how to put into thymeleaf view *1
        return adsDao.findAll();
    }

    //*1
    //thymeleaf view version w info access
    @GetMapping("/rel/ads/view")
    public String returnAdsView(Model model){
        model.addAttribute("ads", adsDao.findAll());
                return "rel/ads";
    }
}


