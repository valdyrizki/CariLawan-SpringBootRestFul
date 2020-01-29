package com.example.CariLawan.implement;

import com.example.CariLawan.exception.MyResourceNotFoundException;
import com.example.CariLawan.model.Player;
import com.example.CariLawan.repository.PlayerRepository;
import com.example.CariLawan.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    @Override
    public Player findById(String player_id){
        return playerRepository.getOne(player_id);
    }

    @Override
    public Player update(String player_id, Player player) throws MyResourceNotFoundException {
        Player p = playerRepository.getOne(player_id);
        p.setPlayerName(player.getPlayerName());
        p.setBirthDate(player.getBirthDate());
        p.setEmail(player.getEmail());
        p.setGender(player.getGender());
        p.setPhone(player.getPhone());
        p.setUpdatedAt(new Date());
        return playerRepository.save(p);
    }

    @Override
    public Player create(Player player){
        return playerRepository.save(player);
    }

    @Override
    public Player delete(String player_id){
        Player p = playerRepository.getOne(player_id);
        p.setSts(9);
        return playerRepository.save(p);
    }

    @Override
    public Player activate(String player_id){
        Player p = playerRepository.getOne(player_id);
        p.setSts(1);
        return playerRepository.save(p);
    }

    @Override
    public List<Player> findBySts(int sts){
       return playerRepository.findBySts(sts);
    }

}
