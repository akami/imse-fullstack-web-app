package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Character;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CharacterService {
    public void saveCharacter(Character character) {
        // TODO @kh character player
    }

    public List<Character> getCharacters() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
