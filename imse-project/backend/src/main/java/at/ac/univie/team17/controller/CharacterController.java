package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Character;
import at.ac.univie.team17.service.CharacterService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController extends BackendController {
    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/character")
    public List<Character> getCharacters(@RequestHeader("Authorization") String authHeader) {
        String playerId = getPlayerId(authHeader);

        return characterService.getCharacters(playerId);
    }

    @PostMapping("/character")
    public ResponseEntity saveCharacter(@RequestBody Character character) {
        characterService.saveCharacter(character);

        return new ResponseEntity(HttpStatus.OK);
    }
}
