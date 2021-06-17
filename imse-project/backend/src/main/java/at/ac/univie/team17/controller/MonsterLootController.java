package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;
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

    @GetMapping("/monster-loot")
    public List<MonsterLoot> getMonsterLoots() {
        return monsterLootService.getMonsterLoots();
    }
}
