package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.service.CharacterSkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterSkinController extends BackendController {
    @Autowired
    private CharacterSkinService characterSkinService;

    @GetMapping("/character-skin")
    public List<CharacterSkin> getCharacterSkins() {
        return characterSkinService.getCharacterSkins();
    }

    @GetMapping("/character-skin/{characterId}")
    public List<CharacterSkin> getCharacterSkinsForCharacterId(@PathVariable("characterId") Integer characterId) {
        return characterSkinService.getCharacterSkinsForCharacterId(characterId);
    }
}
