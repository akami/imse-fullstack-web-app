package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLootWithIds;
import at.ac.univie.team17.service.MonsterLootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MonsterLootController extends BackendController {
    @Autowired
    private MonsterLootService monsterLootService;

    @GetMapping("/maria/monster-loot")
    public List<MonsterLoot> getMonsterLoots() {
        return monsterLootService.getMonsterLoots();
    }

    @GetMapping("/mongo/monster-loot")
    public List<MongoMonsterLootWithIds> getMongoMonsterLoots() {
        return monsterLootService.getMongoMonsterLoots();
    }
}
