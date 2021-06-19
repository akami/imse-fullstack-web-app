package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.QuestRewardQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MongoQuest
{
    private int questId;
    private String questName;
    private String clientName;
    private MongoQuestReward questReward;

    public MongoQuest(int questId, String questName, String clientName, MongoQuestReward questRewardId)
    {
        this.questId = questId;
        this.questName = questName;
        this.clientName = clientName;
        this.questReward = questRewardId;
    }

    public static ArrayList<MongoQuest> getMongoQuestsFromQuest(ArrayList<Quest> completedQuests, Statement statement)
    {
        ArrayList<MongoQuest> mongoQuests = new ArrayList<>();
        for (Quest quest : completedQuests)
        {
            mongoQuests.add(MongoQuest.getMongoQuestFromQuest(quest, statement));
        }
        return mongoQuests;
    }

    private static MongoQuest getMongoQuestFromQuest(Quest quest, Statement statement)
    {
        // get quest reward
        ResultSet rsQuestReward = MariaDBQueryExecuter.executeReturnQuery(
                statement, QuestRewardQueries.getSelectQuestRewardFromIdQuery(quest.getQuestRewardId()));
        QuestReward questReward = MariaDBResultReader.getQuestRewardFromResultSet(rsQuestReward);
        MongoQuestReward mongoQuestReward = new MongoQuestReward(questReward.getGoldAmount(), questReward.getExperienceAmount());

        return new MongoQuest(quest.getQuestId(), quest.getQuestName(), quest.getClientName(), mongoQuestReward);
    }

    public int getQuestId()
    {
        return questId;
    }

    public String getQuestName()
    {
        return questName;
    }

    public String getClientName()
    {
        return clientName;
    }

    public MongoQuestReward getQuestReward()
    {
        return questReward;
    }
}
