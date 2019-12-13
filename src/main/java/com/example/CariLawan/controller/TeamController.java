package com.example.CariLawan.controller;

import com.example.CariLawan.exception.MyResourceNotFoundException;
import com.example.CariLawan.model.Sport;
import com.example.CariLawan.model.Team;
import com.example.CariLawan.repository.SportRepository;
import com.example.CariLawan.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/")
    public List<Team> getTeam() {
        return teamRepository.findByTeamSts(1);
    }

    @GetMapping("/all")
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId)
            throws MyResourceNotFoundException {
        Team team = teamRepository
                .findById(teamId)
                .orElseThrow(() -> new MyResourceNotFoundException("Team ID "+teamId+"  not found on"));
        return ResponseEntity.ok().body(team);
    }

    @PostMapping("/")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }

    //EDIT TEAM
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(
            @PathVariable(value = "id") Long teamId, @Valid @RequestBody Team teamDetails)
            throws MyResourceNotFoundException {
        Team team = teamRepository
                .findById(teamId)
                .orElseThrow(() -> new MyResourceNotFoundException("Team ID "+teamId+" not found."));
        team.setTeamName(teamDetails.getTeamName());
        team.setLevel(teamDetails.getLevel());
        team.setUpdatedAt(new Date());
        final Team updatedTeam = teamRepository.save(team);
        return ResponseEntity.ok(updatedTeam);
    }

    //DELETE TEAM BY ID
    @PutMapping("/status/{id}")
    public ResponseEntity<Team> deleteTeam(
            @PathVariable(value = "id") Long teamId)
            throws MyResourceNotFoundException {
        Team team = teamRepository
                .findById(teamId)
                .orElseThrow(() -> new MyResourceNotFoundException("Team ID "+teamId+" not found."));
        team.setTeamSts(9);
        final Team updatedTeam = teamRepository.save(team);
        return ResponseEntity.ok(updatedTeam);
    }
}
