package com.example.CariLawan.controller;

import com.example.CariLawan.exception.MyResourceNotFoundException;
import com.example.CariLawan.model.Player;
import com.example.CariLawan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/all")
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @GetMapping("/")
    public List<Player> getPlayer() {
        return playerRepository.findBySts(1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") String playerid)
            throws MyResourceNotFoundException {
        Player player = playerRepository
                        .findById(playerid)
                        .orElseThrow(() -> new MyResourceNotFoundException("Player ID "+playerid+"  not found on"));
        return ResponseEntity.ok().body(player);
    }

    @PostMapping("/")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    //EDIT PROFILE
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable(value = "id") String playerid, @Valid @RequestBody Player playerDetails)
            throws MyResourceNotFoundException {
        Player player = playerRepository
                        .findById(playerid)
                        .orElseThrow(() -> new MyResourceNotFoundException("Player ID "+playerid+" not found."));
        player.setPlayerName(playerDetails.getPlayerName());
        player.setEmail(playerDetails.getEmail());
        player.setGender(playerDetails.getGender());
        player.setBirthDate(playerDetails.getBirthDate());
        player.setPhone(playerDetails.getPhone());
        player.setUpdatedAt(new Date());
        final Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayer);
    }

    //DELETE PLAYER
    @PutMapping("/status/{id}")
    public ResponseEntity<Player> deletePlayer(
            @PathVariable(value = "id") String playerid)
            throws MyResourceNotFoundException {
        Player player = playerRepository
                .findById(playerid)
                .orElseThrow(() -> new MyResourceNotFoundException("Player ID "+playerid+" not found."));
        player.setSts(9);
        final Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayer);
    }
}
