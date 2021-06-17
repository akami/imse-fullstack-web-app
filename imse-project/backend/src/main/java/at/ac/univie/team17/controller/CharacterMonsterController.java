package at.ac.univie.team17.controller;

import at.ac.univie.team17.service.CharacterMonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CharacterMonsterController extends BackendController {
    @Autowired
    private CharacterMonsterService characterMonsterService;

// TODO @kh
//    @GetMapping("/character-monster")
//    public List<CharacterMonster> getCharacterMonsters() {
//        return characterMonsterService.getCharacterMonsters();
//    }
}
