package at.ac.univie.team17.mongoDB.mongoDBmodels;

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

    public MongoQuestReward getQuestRewardId()
    {
        return questReward;
    }
}
