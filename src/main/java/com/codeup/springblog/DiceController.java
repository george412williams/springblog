package com.codeup.springblog;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.standard.expression.GreaterOrEqualToExpression;

import java.lang.Math;

import java.util.ArrayList;

@Controller
public class DiceController {

//    @GetMapping("/roll-dice")
//    public String randomDieRoll(){
//            //(@PathVariable int num){
//        ArrayList<Integer> dieRoll = new ArrayList<>();
//        int max = 6;
//        int min = 1;
//        int range = max - min + 1;
//
//        for (int i = 0; i < 6; i++) {
//            int randDieRoll = (int)(Math.random() * range) + min;
//        }
//        return "Random Die Roll Result: ";
//    }

    @GetMapping("/roll-dice")
    public String randDiceRoll(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String viewResults(@PathVariable int guess, Model model){

        int diceRoll = (int) (Math.random() * 6) + 1;
        String message;

        if(diceRoll == guess){
            message = "Bingo!";
        }else{
            message = "No cigar.";
        }

        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("message", message);

        return "roll-results";
    }

//    @RequestMapping(path = "/roll-dice/{guess}", method = RequestMethod.GET)
//        @ResponseBody
//        public String randDiceRoller(@PathVariable String guess, Model model) {
//            model.addAttribute("guess", guess);
//            ArrayList<Integer> dieRoll = new ArrayList<>();
//
//            return "roll-dice";
    //}



}
