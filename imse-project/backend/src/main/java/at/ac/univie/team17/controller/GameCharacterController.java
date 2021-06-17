package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.service.GameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameCharacterController extends BackendController {
    @Autowired
    private GameCharacterService gameCharacterService;

    @GetMapping(value = "/character")
    public List<GameCharacter> getGameCharacters() {
        return gameCharacterService.getGameCharacters();
    }


    @GetMapping(value = "/character/{playerId}")
    public List<GameCharacter> getGameCharacters(@PathParam("playerId") int playerId) {
        return gameCharacterService.getGameCharactersById(playerId);
    }

    @PostMapping("/character")
    public ResponseEntity saveGameCharacter(@RequestBody GameCharacter gameCharacter) {
        gameCharacterService.saveGameCharacter(gameCharacter);

        return new ResponseEntity(HttpStatus.OK);
    }
}
