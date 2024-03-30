package com.example.hellofullstack.repositories;

import com.example.hellofullstack.models.Dice;
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

    public void deleteAll() {
        String query = "delete from player where player_name != 'dfghsfsdjhnsfd';";
        jdbcTemplate.update(query);
    }

    public Dice getDices() {
        String query = "select * from diceroll;";
        RowMapper<Dice> rowMapper = new BeanPropertyRowMapper<>(Dice.class);
        return jdbcTemplate.queryForObject(query, rowMapper);
    }
}