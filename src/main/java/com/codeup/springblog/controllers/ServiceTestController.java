package com.codeup.springblog.controllers;


import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.GreetingSvc;
import com.codeup.springblog.services.SillySvc;

//here have control over you fxality, like a service you call in but don't have access to
//to change the fx's logic, but here you can
@Controller
public class ServiceTestController {
    //after making service, make this

    //inject now
    private GreetingSvc greetingSvc;
    private SillySvc sillySvc;
    //injecting email service
    private EmailService emailService;
    private PostRepository postDao;

    public ServiceTestController(GreetingSvc greetingSvc, SillySvc sillySvc, EmailService emailService, PostRepository postDao) {
        this.greetingSvc = greetingSvc;
        this.sillySvc = sillySvc;
        this.emailService = emailService;
        this.postDao = postDao;
    }
    //inject end

    //===== MAPPING (of logic for the greeting fx

    //===== greetings =======
    @GetMapping("/morning/{name}")
    public String morningGreeting(@PathVariable String name){
        //can use the service now
        return greetingSvc.goodMorning(name);
    }

    @GetMapping("/afternoon/{name}")
    public String afternoonGreeting(@PathVariable String name){
        return greetingSvc.goodAfternoon(name);
    }

    @GetMapping("/evening/{name}")
    public String eveningGreeting(@PathVariable String name){
        return greetingSvc.goodEvening(name);
    }

    //======== silly ============
    @GetMapping("/silly")
    @ResponseBody
    public int totalLength() {
        return sillySvc.totalPostCharacters();
    }

    //========= email =========
    @GetMapping("/email")
    //type in /email and send the email
    @ResponseBody
    public String sendEmail(){
        //use the mail service, when go here use this method: //fit it in too
        emailService.prepareAndSend(postDao.getOne(1L),"First email!", "Test content.");
        return "Check mailtrap inbox.";
    }

}
