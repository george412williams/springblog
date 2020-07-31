package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.Math;

import java.util.ArrayList;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String randomDieRoll(@RequestParam(name = "guess") int guess){
            //(@PathVariable int num){
        ArrayList<Integer> dieRoll = new ArrayList<>();
        int max = 6;
        int min = 1;
        int range = max - min + 1;

        for (int i = 0; i < 6; i++) {
            int randDieRoll = (int)(Math.random() * range) + min;
        }
        return "Random Die Roll Result: ";
    }
}
