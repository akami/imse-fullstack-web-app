package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.SkinReport;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterClassMongoSkins;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkinReport;
import at.ac.univie.team17.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkinController extends BackendController {
    @Autowired
    private SkinService skinService;

    @GetMapping("/maria/skin")
    public List<Skin> getSkins() {
        return skinService.getAllSkins();
    }

    @GetMapping("/mongo/skin")
    public List<CharacterClassMongoSkins> getMongoSkins()
    {
        return skinService.getAllMongoSkins();
    }

    @GetMapping("/maria/skin/{classId}")
    public List<Skin> getSkinsFromClassId(@PathVariable Integer classId) {
        return skinService.getSkinsFromClassId(classId);
    }

    @GetMapping("/mongo/skin/{classId}")
    public List<MongoSkin> getMongoSkinsFromClassId(@PathVariable Integer classId)
    {
        return skinService.getMongoSkinsFromClassId(classId);
    }

    @GetMapping("/maria/skin/character/{characterId}")
    public List<Skin> getAvailableSkinsFromCharacterId(@PathVariable Integer characterId) {
        return skinService.getAvailableSkinsFromCharacterId(characterId);
    }

    @GetMapping("/mongo/skin/character/{characterId}")
    public List<MongoSkin> getAvailableMongoSkinsFromCharacterId(@PathVariable Integer characterId)
    {
        return skinService.getAvailableMongoSkinsFromCharacterId(characterId);
    }

    @PostMapping("/maria/skin/purchase/{characterId}/{skinId}")
    public void addBoughtSkinToCharacter(@PathVariable Integer characterId, @PathVariable Integer skinId)
    {
        skinService.addSkinToCharacter(characterId, skinId);
    }

    @PutMapping("/mongo/skin/purchase/{characterId}")
    public void addBoughtMongoSkinToMongoCharacter(@PathVariable Integer characterId, @RequestBody MongoSkin mongoSkin)
    {
        skinService.addMongoSkinToMongoCharacter(characterId, mongoSkin);
    }

    @GetMapping("/maria/skin/report")
    public List<SkinReport> getSkinReport()
    {
        return skinService.getSkinReport();
    }


    @GetMapping("/mongo/skin/report")
    public List<MongoSkinReport> getMongoSkinReport()
    {
        return skinService.getMongoSkinReport();
    }
}
