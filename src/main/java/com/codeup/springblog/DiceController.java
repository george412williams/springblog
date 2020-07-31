package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    //@ResponseBody
    public String randomDieRoll(@PathVariable int num){
        ArrayList<Integer> dieRoll = new ArrayList<>();

        return "Random Die Roll Result: " + randomDieRoll(num);
    }
}
