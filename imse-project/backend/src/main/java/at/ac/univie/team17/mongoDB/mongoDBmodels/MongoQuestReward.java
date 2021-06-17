package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;

public class MongoQuestReward
{
    private int goldAmount;
    private int experienceAmount;

    public MongoQuestReward(int goldAmount, int experienceAmount)
    {
        this.goldAmount = goldAmount;
        this.experienceAmount = experienceAmount;
    }

    public static MongoQuestReward getMongoQuestRewardFromQuestReward(QuestReward questReward)
    {
        return new MongoQuestReward(questReward.getGoldAmount(), questReward.getExperienceAmount());
    }

    public int getGoldAmount()
    {
        return goldAmount;
    }

    public int getExperienceAmount()
    {
        return experienceAmount;
    }
}
