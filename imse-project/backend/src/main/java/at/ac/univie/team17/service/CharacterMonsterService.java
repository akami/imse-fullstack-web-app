package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterMonsterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMonsterService {

    public List<CharacterMonster> getCharacterMonsters() {
        String query = CharacterMonsterQueries.getSelectAllCharacterMonstersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterMonster> characterMonsters = MariaDBResultReader.getCharacterMonstersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characterMonsters;
    }
}
