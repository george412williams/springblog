package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.repositories.AdRepository;

import java.util.List;

@Controller
public class AdController {

    //THIS IS HOW YOU MAKE YOU'RE OWN API SERVICE
        //IOC of Spring does this, Inversion of Control container, framework makes the objects based on definition which is the dependency injection,
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

    //returning view wo json, the string rep's the data (previous method)
    @GetMapping("/ads/view")
    public String getAdsIndex(Model model) {
        model.addAttribute("ads", adsDao.findAllByOrderByIdDesc());
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

    // ======================= version WITHOUT form model binding

//    @GetMapping("/ads/create")
//    public String showCreateForm() {
//        return "ads/create";
//    }
//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ) {
//        Ad ad = new Ad();
//        ad.setTitle(title);
//        ad.setDescription(description);
//        // save the ad...
//        return "Ad saved!";
//    }

    // ========== WITH form model binding

    //retrieving the object to fill
    @GetMapping("/ads/create")
    public String showCreateForm(Model model){
        //in order to get, send in the object of the correct shape to get the stuff
        model.addAttribute("ad", new Ad());
        //sending in empty ad obj
        return "ads/create";
    }

    //
    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad){
        adsDao.save(ad);
        //what do we return? the view of all ads or the ad/post view
        return "redirect:/ads/view";
            //user now goes to see whole list of ads to verify addition
        //redirect makes sure the page it goes to does its work and not just shows
    }

}
