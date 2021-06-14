package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MonsterService {
    public void saveMonster(Monster monster) {
        // TODO @kh save monster
    }

    public List<Monster> getMonsters() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
