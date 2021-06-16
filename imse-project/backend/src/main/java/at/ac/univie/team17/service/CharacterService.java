package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterService {

    public void saveCharacter(GameCharacter character) {
        String query = CharacterQueries.getInsertCharacterQuery(character);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<GameCharacter> getCharacters(int playerId) {
        String query = CharacterQueries.getSelectCharactersFromPlayerIdQuery(playerId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<GameCharacter> characters = MariaDBResultReader.getGameCharactersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characters;
    }
}
