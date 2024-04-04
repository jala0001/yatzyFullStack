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
                              @RequestParam String ones,
                              @RequestParam String twos,
                              @RequestParam String threes,
                              @RequestParam String fours,
                              @RequestParam String fives,
                              @RequestParam String sixes,
                              @RequestParam String onePair,
                              @RequestParam String twoPair,
                              @RequestParam String threePair,
                              @RequestParam String threeOfAKind,
                              @RequestParam String fourOfAKind,
                              @RequestParam String twoXThree,
                              @RequestParam String littleStraight,
                              @RequestParam String mediumStraight,
                              @RequestParam String royaleStraight,
                              @RequestParam String fullHouse,
                              @RequestParam String chance,
                              @RequestParam String yatzy) {
        yatzyService.insertPlayer1(playerName, ones, twos, threes, fours, fives, sixes,
                onePair, twoPair, threePair, threeOfAKind, fourOfAKind, twoXThree,
                littleStraight, mediumStraight, royaleStraight, fullHouse, chance, yatzy);
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

    @PostMapping("/addScoreOnePair")
    public String addScoreOnePair(@RequestParam String onePair, @RequestParam String playerName) {
        yatzyService.insertValueOnePair(onePair, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreTwoPair")
    public String addScoreTwoPair(@RequestParam String twoPair, @RequestParam String playerName) {
        yatzyService.insertValueTwoPair(twoPair, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreThreePair")
    public String addScoreThreePair(@RequestParam String threePair, @RequestParam String playerName) {
        yatzyService.insertValueThreePair(threePair, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreThreeOfAKind")
    public String addScoreThreeOfAKind(@RequestParam String threeOfAKind, @RequestParam String playerName) {
        yatzyService.insertValueThreeOfAKind(threeOfAKind, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreFourOfAKind")
    public String addScoreFourOfAKind(@RequestParam String fourOfAKind, @RequestParam String playerName) {
        yatzyService.insertValueFourOfAKind(fourOfAKind, playerName);
        return "redirect:/";
    }
    @PostMapping("/addScoreTwoXThree")
    public String addScoreTwoXThree(@RequestParam String twoXThree, @RequestParam String playerName) {
        yatzyService.insertValueTwoXThree(twoXThree, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreLittleStraight")
    public String addScoreLittleStraight(@RequestParam String littleStraight, @RequestParam String playerName) {
        yatzyService.insertValueLittleStraight(littleStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreMediumStraight")
    public String addScoreMediumStraight(@RequestParam String mediumStraight, @RequestParam String playerName) {
        yatzyService.insertValueMediumStraight(mediumStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreRoyaleStraight")
    public String addScoreRoyaleStraight(@RequestParam String royaleStraight, @RequestParam String playerName) {
        yatzyService.insertValueRoyaleStraight(royaleStraight, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreFullHouse")
    public String addScoreFullHouse(@RequestParam String fullHouse, @RequestParam String playerName) {
        yatzyService.insertValueFullHouse(fullHouse, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreChance")
    public String addScoreChance(@RequestParam String chance, @RequestParam String playerName) {
        yatzyService.insertValueChance(chance, playerName);
        return "redirect:/";
    }

    @PostMapping("/addScoreYatzy")
    public String addScoreYatzy(@RequestParam String yatzy, @RequestParam String playerName) {
        yatzyService.insertValueYatzy(yatzy, playerName);
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
