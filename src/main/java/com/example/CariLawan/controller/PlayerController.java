package com.example.CariLawan.controller;

import com.example.CariLawan.exception.MyResourceNotFoundException;
import com.example.CariLawan.model.Player;
import com.example.CariLawan.repository.PlayerRepository;
import com.example.CariLawan.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public List<Player> getAllPlayer() {
        return playerService.findAll();
    }

    @GetMapping("/")
    public List<Player> getPlayer() {
        return playerService.findBySts(1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") String playerid)
            throws MyResourceNotFoundException {
        Player player = playerService
                .findById(playerid);
//                .orElseThrow(() -> new MyResourceNotFoundException("Player ID "+playerid+"  not found on"));
        return ResponseEntity.ok().body(player);
    }

    @PostMapping("/")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerService.create(player);
    }

    //EDIT PROFILE
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable(value = "id") String playerid, @Valid @RequestBody Player playerDetails)
            throws MyResourceNotFoundException {
        return ResponseEntity.ok(playerService.update(playerid,playerDetails));
    }

    //DELETE PLAYER
    @PutMapping("/status/{id}")
    public ResponseEntity<Player> deletePlayer(
            @PathVariable(value = "id") String playerid)
            throws MyResourceNotFoundException {
        final Player updatedPlayer = playerService.findById(playerid);
        playerService.delete(playerid);
        return ResponseEntity.ok(updatedPlayer);
    }

    //ACTIVATE
    @PutMapping("/activate/{id}")
    public ResponseEntity<Player> activatePlayer(
            @PathVariable(value = "id") String playerid)
            throws MyResourceNotFoundException {
        final Player updatedPlayer = playerService.findById(playerid);
        playerService.activate(playerid);
        return ResponseEntity.ok(updatedPlayer);
    }
}
