package controllers;


import models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import repositories.AdRepository;

import java.util.List;

@Controller
public class AdController {

    //THIS IS HOW YOU MAKE YOU'RE OWN API SERVICE

    //==========================
    //dependency injection

    private final AdRepository adsDao;

    public AdController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }

    //THIS IS HOW YOU MAKE ANOTHER JSON/API SERVICE
    //==========================

    //think back to movies, fetch requests, json server, now can create own api service like weather map, etc
    // so want to return a json of list of ads
    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAds(){
        //do this if want json and not thymeleaf view, String etc
            //now for dependency injection above
        return adsDao.findAll();
    }

    //returning view wo json, the string rep's the data
    @GetMapping("/ads/view")
    public String getAdsIndex(Model model) {
        model.addAttribute("ads", adsDao.findAll());
        return "/ads/index";
    }

    //TEST AT THIS POINT SHOWS EMPTY ARRAY WO GTRSSTRS W EMPTY CONSTRUCTOR,
    //AFTER SHOWS UP LIKE API DB DATA W A CHROME EXTENSION
    //THIS IS ALL WO THYMELEAF

    //using a fetch cpypast in console was able to produce the json view in no time

    //lets get a single ad

    @GetMapping("/ads/{id}")
    @ResponseBody
    public String getAd(@PathVariable long id) {
        return adsDao.getOne(id).toString();
        //override the toString to get what you need, gives obj bc asking for String
    }


    //get request and save method, normally in post requst but no simple way to do it right now
    @GetMapping("/ads/save")
//    @ResponseBody
    public String save(){
        //check db before/after to see if works
        Ad adToSave = new Ad();
        adToSave.setTitle("New Ad!");
        adToSave.setDescription("The new desc.");
        adsDao.save(adToSave);
        //redirect to ads to see if it effected, use redirect:
            //redicrect didn't work, but it added the ad, took out response and worked
        return "redirect:/ads";
        }

        //adding search method
            //hibernate will create the implementation of the meth
            //in curric, defining custom query
    @GetMapping("/ads/test")
    @ResponseBody
    public String getTestAd() {
        return adsDao.findByTitle("Biodex").toString();
            //case sensitive right now
    }



}
