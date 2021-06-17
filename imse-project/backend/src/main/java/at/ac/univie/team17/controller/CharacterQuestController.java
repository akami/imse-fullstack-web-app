package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.service.CharacterQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterQuestController extends BackendController {
    @Autowired
    private CharacterQuestService characterQuestService;

    // TODO @kh
    @GetMapping("/character-quest")
    public List<Quest> getCharacterQuests() {
        return characterQuestService.getCharacterQuests();
    }
}
