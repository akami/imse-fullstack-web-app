package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoQuestRewardWithIds
{
    private int questId;
    private MongoQuestReward mongoQuestReward;

    public MongoQuestRewardWithIds(int questId, MongoQuestReward mongoQuestReward)
    {
        this.questId = questId;
        this.mongoQuestReward = mongoQuestReward;
    }

    public int getQuestId()
    {
        return questId;
    }

    public MongoQuestReward getMongoQuestReward()
    {
        return mongoQuestReward;
    }
}
