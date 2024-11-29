package com.bagus.gen_24_java_springboot_pos.controller.pos;

import com.bagus.gen_24_java_springboot_pos.entity.player.Player;
import com.bagus.gen_24_java_springboot_pos.service.db.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/greeting/{playerId}")
    public ResponseEntity<String> greetingPlayer(@PathVariable Long playerId) {
        Optional<Player> player = playerService.findPlayerById(playerId);
        return player.map(value -> ResponseEntity.ok("Welcome player " + value.getNickname())).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found!")
        );
    }

    @GetMapping("/list")
    public ResponseEntity<List<Player>> getAllPlayer() {
        return ResponseEntity.ok(playerService.getAllPlayer());
    }

    @PostMapping()
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

    @PutMapping("{playerId}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable Long playerId,
            @RequestBody Player player
    ) {
        return ResponseEntity.ok(playerService.updatePlayer(playerId, player));
    }

    @DeleteMapping("{playerId}")
    public ResponseEntity deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok("Player with id " + playerId + " has been deleted");
    }
}
