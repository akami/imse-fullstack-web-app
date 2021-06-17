package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.service.CharacterService;
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
    public List<GameCharacter> getCharacters() {
        return characterService.getCharacters();
    }

    @PostMapping("/character")
    public ResponseEntity saveCharacter(@RequestBody GameCharacter character) {
        characterService.saveCharacter(character);

        return new ResponseEntity(HttpStatus.OK);
    }
}
