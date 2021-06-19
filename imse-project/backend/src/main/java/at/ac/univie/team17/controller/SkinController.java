package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterClassMongoSkins;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import at.ac.univie.team17.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
