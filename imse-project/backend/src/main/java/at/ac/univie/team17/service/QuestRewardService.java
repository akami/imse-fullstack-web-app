package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestRewardQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoQuestQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuestRewardWithIds;
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

    public List<MongoQuestRewardWithIds> getMongoQuestRewards()
    {
        List<MongoQuestRewardWithIds> mongoQuestRewards = MongoQuestQueries.getMongoQuestRewardsWithIds();
        return mongoQuestRewards;
    }
}
