package com.example.hellofullstack.controllers;

import com.example.hellofullstack.models.Diceroll;
import com.example.hellofullstack.models.Yatzy;
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
    int rollCount;
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
                              @RequestParam int ones,
                              @RequestParam int twos,
                              @RequestParam int threes,
                              @RequestParam int fours,
                              @RequestParam int fives,
                              @RequestParam int sixes,
                              @RequestParam int sum,
                              @RequestParam int bonus,
                              @RequestParam int onePair,
                              @RequestParam int twoPair,
                              @RequestParam int threePair,
                              @RequestParam int threeOfAKind,
                              @RequestParam int fourOfAKind,
                              @RequestParam int twoXThree,
                              @RequestParam int littleStraight,
                              @RequestParam int mediumStraight,
                              @RequestParam int royaleStraight,
                              @RequestParam int fullHouse,
                              @RequestParam int chance,
                              @RequestParam int yatzy,
                              @RequestParam int total) {
        yatzyService.insertPlayer1(playerName, ones, twos, threes, fours, fives, sixes,sum, bonus,
                onePair, twoPair, threePair, threeOfAKind, fourOfAKind, twoXThree,
                littleStraight, mediumStraight, royaleStraight, fullHouse, chance, yatzy, total);
        return "redirect:/";
    }

    @GetMapping("/addScore")
    public String addScore(@RequestParam String playerName, Model model) {
        model.addAttribute(yatzyService.getPlayer(playerName));
        return "home/addScore";
    }

    @PostMapping("/addScore")
    public String addScore(@RequestParam int ones, @RequestParam String playerName) {
        yatzyService.insertValue(ones, playerName);
        yatzyService.updateSum(ones, playerName);
        yatzyService.updateTotal(ones, playerName);
        yatzyService.bonus(playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore2")
    public String addScore2(@RequestParam int twos, @RequestParam String playerName) {
        yatzyService.insertValue2(twos, playerName);
        yatzyService.updateSum(twos, playerName);
        yatzyService.updateTotal(twos, playerName);
        yatzyService.bonus(playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore3")
    public String addScore3(@RequestParam int threes, @RequestParam String playerName) {
        yatzyService.insertValue3(threes, playerName);
        yatzyService.updateSum(threes, playerName);
        yatzyService.updateTotal(threes, playerName);
        yatzyService.bonus(playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore4")
    public String addScore4(@RequestParam int fours, @RequestParam String playerName) {
        yatzyService.insertValue4(fours, playerName);
        yatzyService.updateSum(fours, playerName);
        yatzyService.updateTotal(fours, playerName);
        yatzyService.bonus(playerName);

        return "redirect:/";
    }

    @PostMapping("/addScore5")
    public String addScore5(@RequestParam int fives, @RequestParam String playerName) {
        yatzyService.insertValue5(fives, playerName);
        yatzyService.updateSum(fives, playerName);
        yatzyService.updateTotal(fives, playerName);
        yatzyService.bonus(playerName);
        return "redirect:/";
    }

    @PostMapping("/addScore6")
    public String addScore6(@RequestParam int sixes, @RequestParam String playerName) {
        yatzyService.insertValue6(sixes, playerName);
        yatzyService.updateSum(sixes, playerName);
        yatzyService.updateTotal(sixes, playerName);
        yatzyService.bonus(playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreOnePair")
    public String addScoreOnePair(@RequestParam int onePair, @RequestParam String playerName) {
        yatzyService.insertValueOnePair(onePair, playerName);
        yatzyService.updateTotal(onePair, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreTwoPair")
    public String addScoreTwoPair(@RequestParam int twoPair, @RequestParam String playerName) {
        yatzyService.insertValueTwoPair(twoPair, playerName);
        yatzyService.updateTotal(twoPair, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreThreePair")
    public String addScoreThreePair(@RequestParam int threePair, @RequestParam String playerName) {
        yatzyService.insertValueThreePair(threePair, playerName);
        yatzyService.updateTotal(threePair, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreThreeOfAKind")
    public String addScoreThreeOfAKind(@RequestParam int threeOfAKind, @RequestParam String playerName) {
        yatzyService.insertValueThreeOfAKind(threeOfAKind, playerName);
        yatzyService.updateTotal(threeOfAKind, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreFourOfAKind")
    public String addScoreFourOfAKind(@RequestParam int fourOfAKind, @RequestParam String playerName) {
        yatzyService.insertValueFourOfAKind(fourOfAKind, playerName);
        yatzyService.updateTotal(fourOfAKind, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreTwoXThree")
    public String addScoreTwoXThree(@RequestParam int twoXThree, @RequestParam String playerName) {
        yatzyService.insertValueTwoXThree(twoXThree, playerName);
        yatzyService.updateTotal(twoXThree, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreLittleStraight")
    public String addScoreLittleStraight(@RequestParam int littleStraight, @RequestParam String playerName) {
        yatzyService.insertValueLittleStraight(littleStraight, playerName);
        yatzyService.updateTotal(littleStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreMediumStraight")
    public String addScoreMediumStraight(@RequestParam int mediumStraight, @RequestParam String playerName) {
        yatzyService.insertValueMediumStraight(mediumStraight, playerName);
        yatzyService.updateTotal(mediumStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreRoyaleStraight")
    public String addScoreRoyaleStraight(@RequestParam int royaleStraight, @RequestParam String playerName) {
        yatzyService.insertValueRoyaleStraight(royaleStraight, playerName);
        yatzyService.updateTotal(royaleStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreFullHouse")
    public String addScoreFullHouse(@RequestParam int fullHouse, @RequestParam String playerName) {
        yatzyService.insertValueFullHouse(fullHouse, playerName);
        yatzyService.updateTotal(fullHouse, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreChance")
    public String addScoreChance(@RequestParam int chance, @RequestParam String playerName) {
        yatzyService.insertValueChance(chance, playerName);
        yatzyService.updateTotal(chance, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreYatzy")
    public String addScoreYatzy(@RequestParam int yatzy, @RequestParam String playerName) {
        yatzyService.insertValueYatzy(yatzy, playerName);
        yatzyService.updateTotal(yatzy, playerName);
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
            rollCount = 1;
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
        if (rollCount >= 3) {
            return "redirect:/"; // Returner til hovedsiden, hvis brugeren allerede har slået tre gange
        }

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



    @PostMapping("/reset")
    public String reset() {
        rollCount = 1;
        yatzyService.deletePreviousRoll();
        chosenNumbers.clear();
        amountOfDices = 6;
        return "redirect:/";
    }


    @PostMapping("/chooseDices")
    public String chooseDices(@RequestParam int diceNumber, @RequestParam int value) {
        chosenNumbers.add(value);
        amountOfDices--;
        yatzyService.deleteDice(diceNumber);

        return "redirect:/rollDices";
    }


}
