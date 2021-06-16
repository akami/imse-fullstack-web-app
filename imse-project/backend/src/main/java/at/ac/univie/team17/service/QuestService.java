package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestService {
    public void saveQuest(Quest quest) {

        String query = QuestQueries.getInsertQuestQuery(quest);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<Quest> getQuests() {
        String query = QuestQueries.getSelectAllQuestsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return quests;
    }
}
