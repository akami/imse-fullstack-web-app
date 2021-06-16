package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import at.ac.univie.team17.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MonsterController extends BackendController {
    @Autowired
    private MonsterService monsterService;

    @GetMapping("/monster")
    public List<Monster> getMonsters() {
        return monsterService.getMonsters();
    }

    @PostMapping("/monster")
    public ResponseEntity saveMonster(@RequestBody Monster monster) {
        monsterService.saveMonster(monster);

        return new ResponseEntity(HttpStatus.OK);
    }
}
