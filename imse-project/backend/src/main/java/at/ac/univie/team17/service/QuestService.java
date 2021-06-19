package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoQuestQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestService {
    public List<Quest> getQuests() {
        String query = QuestQueries.getSelectAllQuestsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return quests;
    }

    public List<MongoQuest> getMongoQuests()
    {
        List<MongoQuest> quests = MongoQuestQueries.getMongoQuests();
        return quests;
    }
}
