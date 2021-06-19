package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MonsterController extends BackendController {
    @Autowired
    private MonsterService monsterService;

    @GetMapping("/maria/monster")
    public List<Monster> getMonsters() {
        return monsterService.getMonsters();
    }

    @GetMapping("/mongo/monster")
    public List<MongoMonster> getMongoMonsters()
    {
        return monsterService.getMongoMonsters();
    }
}
