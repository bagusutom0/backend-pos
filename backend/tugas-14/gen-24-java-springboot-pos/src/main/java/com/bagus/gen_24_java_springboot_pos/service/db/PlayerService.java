package com.bagus.gen_24_java_springboot_pos.service.db;

import com.bagus.gen_24_java_springboot_pos.entity.player.Player;
import com.bagus.gen_24_java_springboot_pos.entity.player.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @Transactional
    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setNickname(updatedPlayer.getNickname());
                    player.setLevel(updatedPlayer.getLevel());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Optional<Player> findPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }
}
