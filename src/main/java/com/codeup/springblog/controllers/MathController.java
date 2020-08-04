package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return "Adding " + num1 + " and " + num2 + ": " + (num1 + num2);
        //return String.valueOf(num1 + num2);
    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return "Subtract " + num1 + " from " + num2 + ": " + (num2 - num1);
    }

    //mult
    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return "Multiply " + num1 + " and " + num2 + ": " + (num1 * num2);
    }

    //divide
    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return "Dividing " + num1 + " by " + num2 + ": " + (num1 / num2);
    }
}
