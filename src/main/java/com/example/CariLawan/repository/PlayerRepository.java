package com.example.CariLawan.repository;

import com.example.CariLawan.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findBySts (int Sts);
}
