package com.example.CariLawan.service;

import com.example.CariLawan.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findById(String player_id);
    Player update(String player_id, Player player);
    Player create(Player player);
    Player delete(String player_id);
    Player activate(String player_id);
    List<Player> findBySts(int sts);
}
