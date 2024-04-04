package com.example.hellofullstack.services;

import com.example.hellofullstack.models.Diceroll;
import com.example.hellofullstack.models.Yatzy;
import com.example.hellofullstack.repositories.YatzyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YatzyService {
@Autowired
    YatzyRepository yatzyRepository;



    public List<Yatzy> getPlayers() {
        return yatzyRepository.getPlayers();
    }

    public Yatzy getPlayer(String playerName) {
        return yatzyRepository.getPlayer(playerName);
    }


    public void deleteAll() {
        yatzyRepository.deleteAll();
    }

    public Diceroll getDices() {
        return yatzyRepository.getDices();
    }

    public void diceRoll(int value1, int value2, int value3, int value4, int value5, int value6) {
        yatzyRepository.diceRoll(value1, value2, value3, value4, value5, value6);
    }


    public void deleteDice(int diceNumber) {
       yatzyRepository.deleteDice(diceNumber);
    }

    public void deletePreviousRoll() {
        yatzyRepository.deletePreviousRoll();
    }

    public void insertPlayer1(String playerName, int ones, int twos,
                              int threes, int fours, int fives, int sixes,
                              int sum, int bonus,
                              int onePair, int twoPair, int threePair,
                              int threeOfAKind, int fourOfAKind, int twoXThree,
                              int littleStraight, int mediumStraight, int royaleStraight,
                              int fullHouse, int chance, int yatzy, int total) {
        yatzyRepository.insertPlayer1(playerName, ones, twos, threes, fours, fives, sixes, sum, bonus, onePair,
                twoPair, threePair, threeOfAKind, fourOfAKind, twoXThree, littleStraight, mediumStraight,
                royaleStraight, fullHouse, chance, yatzy, total);
    }


    public void insertValue(int ones, String playerName) {
        yatzyRepository.insertValue(ones, playerName);
    }

    public void insertValue2(int twos, String playerName) {
        yatzyRepository.insertValue2(twos, playerName);
    }

    public void insertValue3(int threes, String playerName) {
        yatzyRepository.insertValue3(threes, playerName);
    }

    public void insertValue4(int fours, String playerName) {
        yatzyRepository.insertValue4(fours, playerName);
    }

    public void insertValue5(int fives, String playerName) {
        yatzyRepository.insertValue5(fives, playerName);
    }

    public void insertValue6(int sixes, String playerName) {
        yatzyRepository.insertValue6(sixes, playerName);
    }

    public void insertValueOnePair(int onePair, String playerName) {
        yatzyRepository.insertValueOnePair(onePair, playerName);
    }

    public void insertValueTwoPair(int twoPair, String playerName) {
        yatzyRepository.insertValueTwoPair(twoPair, playerName);
    }

    public void insertValueThreePair(int threePair, String playerName) {
        yatzyRepository.insertValueThreePair(threePair, playerName);
    }

    public void insertValueLittleStraight(int littleStraight, String playerName) {
        yatzyRepository.insertValueLittleStraight(littleStraight, playerName);
    }

    public void insertValueMediumStraight(int mediumStraight, String playerName) {
        yatzyRepository.insertValueMediumStraight(mediumStraight, playerName);
    }

    public void insertValueRoyaleStraight(int royaleStraight, String playerName) {
        yatzyRepository.insertValueRoyaleStraight(royaleStraight, playerName);
    }

    public void insertValueFullHouse(int fullHouse, String playerName) {
        yatzyRepository.insertValueFullHouse(fullHouse, playerName);
    }

    public void insertValueChance(int chance, String playerName) {
        yatzyRepository.insertValueChance(chance, playerName);
    }

    public void insertValueYatzy(int yatzy, String playerName) {
        yatzyRepository.insertValueYatzy(yatzy, playerName);
    }

    public void insertValueThreeOfAKind(int threeOfAKind, String playerName) {
        yatzyRepository.insertValueThreeOfAKind(threeOfAKind, playerName);
    }

    public void insertValueFourOfAKind(int fourOfAKind, String playerName) {
        yatzyRepository.insertValueFourOfAKind(fourOfAKind, playerName);
    }

    public void insertValueTwoXThree(int twoXThree, String playerName) {
        yatzyRepository.insertValueTwoXThree(twoXThree, playerName);
    }

    public void updateSum(int value, String playerName) {
        yatzyRepository.updateSum(value, playerName);
    }

    public void updateTotal(int value, String playerName) {
        yatzyRepository.updateTotal(value, playerName);
    }

    public void bonus(String playerName) {
        yatzyRepository.bonus(playerName);
    }
}
