package com.example.hellofullstack.repositories;

import com.example.hellofullstack.models.Diceroll;
import com.example.hellofullstack.models.Yatzy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YatzyRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;



    public void diceRoll(int value1, int value2,
                         int value3, int value4,
                         int value5, int value6) {
        String query = "insert into diceroll(value1, value2, value3, value4, value5, value6)" +
                "values(?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, value1, value2, value3, value4, value5, value6);
    }

    public List<Yatzy> getPlayers() {
        String query = "select * from player;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Yatzy.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public Yatzy getPlayer(String playerName) {
        String query = "select * from player where player_name = ?;";
        RowMapper<Yatzy> rowMapper = new BeanPropertyRowMapper<>(Yatzy.class);
        return jdbcTemplate.queryForObject(query, rowMapper, playerName);

    }
    

    public void deleteAll() {
        String query = "delete from player where player_name != 'dfghsfsdjhnsfd';";
        jdbcTemplate.update(query);
    }

    public Diceroll getDices() {
        String query = "select * from diceroll;";
        RowMapper<Diceroll> rowMapper = new BeanPropertyRowMapper<>(Diceroll.class);
        return jdbcTemplate.queryForObject(query, rowMapper);
    }


    public void deleteDice(int diceNumber) {
        if (diceNumber == 1) {
            String query = "update diceroll " +
                    "set value1 = ?";
            jdbcTemplate.update(query, 0);
        } else if (diceNumber == 2) {
            String query = "update diceroll " +
                    "set value2 = ?";
            jdbcTemplate.update(query, 0);
        } else if (diceNumber == 3) {
            String query = "update diceroll " +
                    "set value3 = ?";
            jdbcTemplate.update(query, 0);
        } else if (diceNumber == 4) {
            String query = "update diceroll " +
                    "set value4 = ?";
            jdbcTemplate.update(query, 0);
        } else if (diceNumber == 5) {
            String query = "update diceroll " +
                    "set value5 = ?";
            jdbcTemplate.update(query, 0);
        } else if (diceNumber == 6) {
            String query = "update diceroll " +
                    "set value6 = ?";
            jdbcTemplate.update(query, 0);
        }
    }

    public void deletePreviousRoll() {
        String query = "delete from diceroll;";
        jdbcTemplate.update(query);
    }

    public void insertPlayer1(String playerName, String ones, String twos, String threes,
                              String fours, String fives, String sixes, String onePair,
                              String twoPair, String threePair, String threeOfKind, String fourOfKind,
                              String twoTimesThree, String littleStraight, String mediumStraight,
                              String royaleStraight, String fullHouse, String chance, String yatzy) {

        String query = "insert into player(player_name, ones, twos, threes, fours, fives, " +
                "sixes, one_pair, two_pair, three_pair, three_of_a_kind, four_of_a_kind, " +
                "two_x_three, little_straight, medium_straight, royale_straight, full_house, " +
                "chance, yatzy) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, playerName, ones, twos, threes, fours, fives, sixes,
                onePair, twoPair, threePair, threeOfKind, fourOfKind, twoTimesThree,
                littleStraight, mediumStraight, royaleStraight, fullHouse, chance, yatzy);
    }

    public void insertPlayer1(String playerName,
                              String ones,
                              String twos,
                              String threes,
                              String fours,
                              String fives,
                              String sixes) {
        String query = "insert into player(player_name, ones, twos, threes, fours, fives, sixes)" +
                "values(?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, playerName, ones, twos, threes, fours, fives, sixes);
    }

    public void insertValue(String ones, String playerName) {
        String query = "update player " +
                "set ones = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, ones, playerName);
    }

    public void insertValue2(String twos, String playerName) {
        String query = "update player " +
                "set twos = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, twos, playerName);
    }

    public void insertValue3(String threes, String playerName) {
        String query = "update player " +
                "set threes = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, threes, playerName);
    }

    public void insertValue4(String fours, String playerName) {
        String query = "update player " +
                "set fours = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, fours, playerName);
    }

    public void insertValue5(String fives, String playerName) {
        String query = "update player " +
                "set fives = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, fives, playerName);
    }

    public void insertValue6(String sixes, String playerName) {
        String query = "update player " +
                "set sixes = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, sixes, playerName);
    }
    public void insertValueOnePair(String onePair, String playerName) {
        String query = "update player " +
                "set one_pair = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, onePair, playerName);
    }
    public void insertValueTwoPair(String twoPair, String playerName) {
        String query = "update player " +
                "set two_pair = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, twoPair, playerName);
    }


    public void insertValueThreePair(String threePair, String playerName) {
        String query = "update player " +
                "set three_pair = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, threePair, playerName);
    }

    public void insertValueLittleStraight(String littleStraight, String playerName) {
        String query = "update player " +
                "set little_straight = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, littleStraight, playerName);
    }

    public void insertValueMediumStraight(String mediumStraight, String playerName) {
        String query = "update player " +
                "set medium_straight = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, mediumStraight, playerName);
    }

    public void insertValueRoyaleStraight(String royaleStraight, String playerName) {
        String query = "update player " +
                "set royale_straight = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, royaleStraight, playerName);
    }

    public void insertValueFullHouse(String fullHouse, String playerName) {
        String query = "update player " +
                "set full_house = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, fullHouse, playerName);
    }

    public void insertValueChance(String chance, String playerName) {
        String query = "update player " +
                "set chance = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, chance, playerName);
    }

    public void insertValueYatzy(String yatzy, String playerName) {
        String query = "update player " +
                "set yatzy = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, yatzy, playerName);
    }

    public void insertValueThreeOfAKind(String threeOfAKind, String playerName) {
        String query = "update player " +
                "set three_of_a_kind = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, threeOfAKind, playerName);
    }

    public void insertValueFourOfAKind(String fourOfAKind, String playerName) {
        String query = "update player " +
                "set four_of_a_kind = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, fourOfAKind, playerName);
    }

    public void insertValueTwoXThree(String twoXThree, String playerName) {
        String query = "update player " +
                "set two_x_three = ? " +
                "where player_name = ?;";
        jdbcTemplate.update(query, twoXThree, playerName);
    }
}
