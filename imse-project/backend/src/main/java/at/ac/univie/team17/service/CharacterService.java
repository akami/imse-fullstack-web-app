package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBModel;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CharacterService {
    @Autowired
    private MariaDBModel mariaDBModel;

    public void saveCharacter(Character character) {
        // TODO @kh character player
    }

    public List<Character> getCharacters() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
