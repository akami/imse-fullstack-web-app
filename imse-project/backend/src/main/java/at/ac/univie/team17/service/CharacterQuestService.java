package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterQuestQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterQuestService {

    // TODO @kh
    public List<Quest> getCharacterQuests() {
        String query = CharacterQuestQueries.getSelectAllCharacterQuestsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return quests;
    }
}
