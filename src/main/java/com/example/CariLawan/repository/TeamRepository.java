package com.example.CariLawan.repository;

import com.example.CariLawan.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByTeamSts (int TeamSts);
}
