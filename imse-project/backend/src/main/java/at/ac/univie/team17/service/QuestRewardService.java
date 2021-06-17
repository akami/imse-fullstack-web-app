package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestQueries;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestRewardQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestRewardService {
    public List<QuestReward> getQuestRewards() {
        String query = QuestRewardQueries.getSelectAllQuestRewardsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<QuestReward> questRewards = MariaDBResultReader.getQuestRewardsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return questRewards;
    }
}
