package controllers;


import models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repositories.AdRepository;

import java.util.List;

@Controller
public class AdController {

    //THIS IS HOW YOU MAKE YOU'RE OWN API SERVICE

    //dependency injection
    private final AdRepository adsDao;

    public AdController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }


    //think back to movies, fetch requests, json server, now can create own api service like weather map, etc
    // so want to return a json of list of ads
    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAds(){
        //do this if want json and not thymeleaf view, String etc
            //now for dependency injection above
        return adsDao.findAll();
    }

    //TEST AT THIS POINT SHOWS EMPTY ARRAY WO GTRSSTRS W EMPTY CONSTRUCTOR,
    //AFTER SHOWS UP LIKE API DB DATA W A CHROME EXTENSION
    //THIS IS ALL WO THYMELEAF

    //using a fetch cpypast in console was able to produce the json view in no time


}
