package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterQuestQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterQuest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterQuestService {

    public List<Quest> getCharacterQuests() {
        String query = CharacterQuestQueries.getSelectAllCharacterQuestsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return quests;
    }

    public void characterCompletedQuest(Integer characterId, Integer questId)
    {
        MariaDBConnectionHandler.setupConnection();

        String query = CharacterQuestQueries.getInsertCharacterQuestQuery(new CharacterQuest(characterId, questId));
        MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public void mongoCharacterCompletedMongoQuest(Integer characterId, MongoQuest mongoQuest)
    {
            MongoCharacterQueries.addCompletedQuestToCharacter(characterId, mongoQuest);

    }
}
