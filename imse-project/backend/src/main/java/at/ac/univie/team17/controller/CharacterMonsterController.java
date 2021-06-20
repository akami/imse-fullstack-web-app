package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterSlayedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.SlayedMonsters;
import at.ac.univie.team17.service.CharacterMonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterMonsterController extends BackendController {
    @Autowired
    private CharacterMonsterService characterMonsterService;

    @GetMapping("/maria/character-monster")
    public List<CharacterMonster> getCharacterMonsters() {
        return characterMonsterService.getCharacterMonsters();
    }

    @GetMapping("/mongo/character-monster")
    public List<CharacterSlayedMonsters> getCharacterSlayedMonsters()
    {
        return characterMonsterService.getCharacterSlayedMonsters();
    }

    @PostMapping("/maria/character-monster/{characterId}/{monsterId}")
    public void addSlayedMonsterToGameCharacter(@PathVariable("characterId") Integer characterId,
                                                @PathVariable("monsterId") Integer monsterId)
    {
        characterMonsterService.addSlayedMonsterToGameCharacter(characterId, monsterId);
    }

    @PostMapping("/mongo/character-monster/{playerId}/{characterId}")
    public void addSlayedMonsterToMongoCharacter(@PathVariable("playerId") Integer playerId,
                                                 @PathVariable("characterId") Integer characterId,
                                                 @RequestBody MongoMonster monsterId)
    {
        characterMonsterService.addSlayedMonsterToMongoCharacter(playerId, characterId, monsterId);
    }
}
