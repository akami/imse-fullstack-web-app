package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.service.GameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameCharacterController extends BackendController {
    @Autowired
    private GameCharacterService gameCharacterService;

    @GetMapping(value = "/maria/character")
    public List<GameCharacter> getGameCharacters() {
        return gameCharacterService.getGameCharacters();
    }

    @GetMapping(value = "/mongo/character")
    public List<MongoCharacter> getMongoCharacters() {
        return gameCharacterService.getMongoCharacters();
    }


    @GetMapping(value = "/maria/character/{playerId}")
    public List<GameCharacter> getGameCharacters(@PathVariable("playerId") Integer playerId) {
        return gameCharacterService.getGameCharactersById(playerId);
    }

    @GetMapping(value = "/mongo/character/{playerId}")
    public List<MongoCharacter> getMongoCharacters(@PathVariable("playerId") Integer playerId) {
        return gameCharacterService.getMongoCharactersByPlayerId(playerId);
    }

    @PostMapping("/maria/character")
    public ResponseEntity createGameCharacter(@RequestBody GameCharacter gameCharacter) {
        gameCharacterService.createGameCharacter(gameCharacter);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/mongo/character")
    public ResponseEntity createMongoCharacter(@RequestBody GameCharacter gameCharacter, @RequestBody Integer age)
    {
        gameCharacterService.createMongoCharacter(gameCharacter, age);
        return new ResponseEntity(HttpStatus.OK);
    }
}
