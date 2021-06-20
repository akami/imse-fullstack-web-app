package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
import at.ac.univie.team17.service.CharacterSkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterSkinController extends BackendController {
    @Autowired
    private CharacterSkinService characterSkinService;

    @GetMapping("/maria/character-skin")
    public List<CharacterSkin> getCharacterSkins() {
        return characterSkinService.getCharacterSkins();
    }

    @GetMapping("/mongo/character-skin")
    public List<MongoCharacterSkin> getMongoCharacterSkins()
    {
        return characterSkinService.getMongoCharacterSkins();
    }

    @GetMapping("/maria/character-skin/{characterId}")
    public List<CharacterSkin> getCharacterSkinsForCharacterId(@PathVariable("characterId") Integer characterId) {
        return characterSkinService.getCharacterSkinsForCharacterId(characterId);
    }

    @GetMapping("/mongo/character-skin/{characterId}")
    public List<MongoCharacterSkin> getMongoCharacterSkinsForCharacterId(@PathVariable("characterId") Integer characterId)
    {
        return characterSkinService.getMongoCharacterSkinsForCharacterId(characterId);
    }
}
