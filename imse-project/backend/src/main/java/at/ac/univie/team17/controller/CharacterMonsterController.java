package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;
import at.ac.univie.team17.service.CharacterMonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterMonsterController extends BackendController {
    @Autowired
    private CharacterMonsterService characterMonsterService;

    @GetMapping("/character-monster")
    public List<CharacterMonster> getCharacterMonsters() {
        return characterMonsterService.getCharacterMonsters();
    }
}
