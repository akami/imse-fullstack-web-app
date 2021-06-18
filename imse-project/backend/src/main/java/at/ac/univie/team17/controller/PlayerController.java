package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
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

    @GetMapping("/maria/player")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/mongo/player")
    public List<MongoPlayer> getMongoPlayers()
    {
        return playerService.getMongoPlayers();
    }

    @GetMapping("/maria/player/{username}")
    public Player getPlayerByUsername(@PathVariable("username") String username) {
        return playerService.getPlayerByUsername(username);
    }

    @GetMapping("/mongo/player/{username}")
    public MongoPlayer getMongoPlayerByUsername(@PathVariable("username") String username) {
        return playerService.getMongoPlayerByUsername(username);
    }

    @PostMapping("/maria/player")
    public ResponseEntity createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/mongo/player")
    public ResponseEntity createMongoPlayer(@RequestBody Player player)
    {
        playerService.createMongoPlayer(player);
        return new ResponseEntity(HttpStatus.OK);
    }
}
