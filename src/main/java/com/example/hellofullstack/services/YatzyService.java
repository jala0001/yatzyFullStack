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

    public void insertPlayer1(String playerName,
                              String ones,
                              String twos,
                              String threes,
                              String fours,
                              String fives,
                              String sixes) {
    yatzyRepository.insertPlayer1(playerName, ones, twos, threes, fours, fives, sixes);
    }

    public List<Yatzy> getPlayers() {
        return yatzyRepository.getPlayers();
    }

    public Yatzy getPlayer(String playerName) {
        return yatzyRepository.getPlayer(playerName);
    }

    public void insertValue(String ones, String playerName) {
        yatzyRepository.insertValue(ones, playerName);
    }

    public void insertValue2(String twos, String playerName) {
        yatzyRepository.insertValue2(twos, playerName);
    }
    public void insertValue3(String threes, String playerName) {
        yatzyRepository.insertValue3(threes, playerName);
    }
    public void insertValue4(String fours, String playerName) {
        yatzyRepository.insertValue4(fours, playerName);
    }
    public void insertValue5(String fives, String playerName) {
        yatzyRepository.insertValue5(fives, playerName);
    }
    public void insertValue6(String sixes, String playerName) {
        yatzyRepository.insertValue6(sixes, playerName);
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
}
