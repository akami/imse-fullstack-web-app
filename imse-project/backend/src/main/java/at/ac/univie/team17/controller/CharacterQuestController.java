package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import at.ac.univie.team17.service.CharacterQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterQuestController extends BackendController {
    @Autowired
    private CharacterQuestService characterQuestService;

    @GetMapping("/character-quest")
    public List<Quest> getCharacterQuests() {
        return characterQuestService.getCharacterQuests();
    }

    @PostMapping("/maria/character-quest/complete/{characterId}/{questId}")
    public void characterCompletedQuest(@PathVariable("characterId") Integer characterId, @PathVariable("questId") Integer questId)
    {
        characterQuestService.characterCompletedQuest(characterId, questId);
    }

    @PutMapping("/mongo/character-quest/complete/{characterId}")
    public void addBoughtMongoSkinToMongoCharacter(@PathVariable("characterId") Integer characterId, @RequestBody MongoQuest mongoQuest)
    {
        characterQuestService.mongoCharacterCompletedMongoQuest(characterId, mongoQuest);
    }
}
