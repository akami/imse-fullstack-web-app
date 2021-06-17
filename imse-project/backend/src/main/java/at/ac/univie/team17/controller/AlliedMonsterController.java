package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.AlliedMonsters;
import at.ac.univie.team17.service.AlliedMonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlliedMonsterController extends BackendController {
    @Autowired
    private AlliedMonsterService alliedMonsterService;

    @GetMapping("/allied-monster")
    public List<AlliedMonsters> getAlliedMonsters() {
        return alliedMonsterService.getAlliedMonsters();
    }
}
