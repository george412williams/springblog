package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//first is to define as controller, could find out later that wo @ notation here
    //first endpoint mapping and response body followed by body def
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye from Spring!";
    }

    //path gives access to the var /{name...
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name){
//        return "Hello " + name + ". " + name + "! Look out!";
//    }

    //based on a book id, give opportunity to define the data type, long here
    @GetMapping("/books/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id){
        //get this id and connect to my db to get book info
        //return the view of:
        return "Viewing book " + id;
    }

    //request mapping, also define actual request method...  method = RequestMethod.GET
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name + ". " + name + "! Duck!";
    }

    @GetMapping("/play-pen/{callsign}")
    public String play(@PathVariable String callsign, Model model) {
        model.addAttribute("callsign", callsign);
        return "play-pen";
    }



}
