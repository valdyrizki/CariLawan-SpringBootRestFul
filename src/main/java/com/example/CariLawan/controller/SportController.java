package com.example.CariLawan.controller;

import com.example.CariLawan.exception.MyResourceNotFoundException;
import com.example.CariLawan.model.Sport;
import com.example.CariLawan.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sport")
public class SportController {
    @Autowired
    private SportRepository sportRepository;

    @GetMapping("/")
    public List<Sport> getAllSport() {
        return sportRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable(value = "id") String sportId)
            throws MyResourceNotFoundException {
        Sport sport = sportRepository
                .findById(sportId)
                .orElseThrow(() -> new MyResourceNotFoundException("Sport ID "+sportId+"  not found on"));
        return ResponseEntity.ok().body(sport);
    }

    @PostMapping("/")
    public Sport createSport(@Valid @RequestBody Sport sport) {
        return sportRepository.save(sport);
    }

    //EDIT PROFILE
    @PutMapping("/{id}")
    public ResponseEntity<Sport> updateSport(
            @PathVariable(value = "id") String sportId, @Valid @RequestBody Sport sportDetails)
            throws MyResourceNotFoundException {
        Sport sport = sportRepository
                .findById(sportId)
                .orElseThrow(() -> new MyResourceNotFoundException("Sport ID "+sportId+" not found."));
        sport.setSportName(sportDetails.getSportName());
        sport.setUpdatedAt(new Date());
        final Sport updatedSport = sportRepository.save(sport);
        return ResponseEntity.ok(updatedSport);
    }

    //DELETE SPORT BY ID
    @DeleteMapping("/{id}")
    public String deleteSport(
            @PathVariable(value = "id") String sportId)
            throws MyResourceNotFoundException {
        Sport sport = sportRepository
                .findById(sportId)
                .orElseThrow(() -> new MyResourceNotFoundException("Sport ID "+sportId+" not found."));
        sportRepository.delete(sport);
        return "Sport ID "+sportId+" Successfully Deleted.";
    }
}
