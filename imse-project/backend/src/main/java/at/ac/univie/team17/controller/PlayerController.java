package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController extends BackendController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/player/{username}")
    public Player getPlayerByUsername(@PathVariable("username") String username) {
        return playerService.getPlayerByUsername(username);
    }

    @PostMapping("/player")
    public ResponseEntity createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);

        return new ResponseEntity(HttpStatus.OK);
    }
}
