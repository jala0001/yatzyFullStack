package com.example.hellofullstack.controllers;

import com.example.hellofullstack.models.Diceroll;
import com.example.hellofullstack.services.YatzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class YatzyController {
    int rollCount = 1;
    List<Integer> chosenNumbers = new ArrayList<>();
    int amountOfDices = 6;
    Random random = new Random();
    @Autowired
    private YatzyService yatzyService;

    @GetMapping("/typePlayer1")
    public String typePlayer1() {
        return "home/typePlayer1";
    }

    @PostMapping("/typePlayer1")
    public String typePlayer1(@RequestParam String playerName,
                              @RequestParam String ones,
                              @RequestParam String twos,
                              @RequestParam String threes,
                              @RequestParam String fours,
                              @RequestParam String fives,
                              @RequestParam String sixes) {
        yatzyService.insertPlayer1(playerName, ones, twos, threes, fours, fives, sixes);
        return "redirect:/";
    }

    @GetMapping("/addScore")
    public String addScore(@RequestParam String playerName, Model model) {
        model.addAttribute(yatzyService.getPlayer(playerName));
        return "home/addScore";
    }

    @PostMapping("/addScore")
    public String addScore(@RequestParam String ones, @RequestParam String playerName) {
        yatzyService.insertValue(ones, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore2")
    public String addScore2(@RequestParam String twos, @RequestParam String playerName) {
        yatzyService.insertValue2(twos, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScore3")
    public String addScore3(@RequestParam String threes, @RequestParam String playerName) {
        yatzyService.insertValue3(threes, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore4")
    public String addScore4(@RequestParam String fours, @RequestParam String playerName) {
        yatzyService.insertValue4(fours, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore5")
    public String addScore5(@RequestParam String fives, @RequestParam String playerName) {
        yatzyService.insertValue5(fives, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScore6")
    public String addScore6(@RequestParam String sixes, @RequestParam String playerName) {
        yatzyService.insertValue6(sixes, playerName);
        return "redirect:/";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        yatzyService.deleteAll();
        return "redirect:/";
    }

    @GetMapping("/rollDices")
    public String rollDices(Model model) {
        if (amountOfDices == 6) {
            int value1 = random.nextInt(6) + 1;
            int value2 = random.nextInt(6) + 1;
            int value3 = random.nextInt(6) + 1;
            int value4 = random.nextInt(6) + 1;
            int value5 = random.nextInt(6) + 1;
            int value6 = random.nextInt(6) + 1;
            yatzyService.diceRoll(value1, value2, value3, value4, value5, value6);
        }
        model.addAttribute("chosenNumbers", chosenNumbers);
        model.addAttribute(yatzyService.getDices());
    return "home/rollDices";
    }

    @GetMapping("/rollDices2")
    public String rollDices2(Model model) {
        yatzyService.deletePreviousRoll();
        rollCount++;

        int[] remainingDices = new int[6];

        for (int i = 0; i < amountOfDices; i++) {
            remainingDices[i] = random.nextInt(6) + 1;
        }

        for (int i = amountOfDices; i < 6; i++) {
            remainingDices[i] = 0;
        }


        yatzyService.diceRoll(remainingDices[0], remainingDices[1], remainingDices[2], remainingDices[3], remainingDices[4], remainingDices[5]);

        model.addAttribute("chosenNumbers", chosenNumbers);
        model.addAttribute(yatzyService.getDices());
        model.addAttribute("rollCount", rollCount);
        return "home/rollDices";
    }


    @PostMapping("/chooseDices")
    public String chooseDices(@RequestParam int diceNumber, @RequestParam int value) {
        chosenNumbers.add(value);
        amountOfDices--;
        yatzyService.deleteDice(diceNumber);
        return "redirect:/rollDices";
    }





}
