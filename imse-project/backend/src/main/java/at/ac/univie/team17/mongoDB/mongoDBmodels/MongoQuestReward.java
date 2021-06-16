package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoQuestReward
{
    private int goldAmount;
    private int experienceAmount;

    public MongoQuestReward(int goldAmount, int experienceAmount)
    {
        this.goldAmount = goldAmount;
        this.experienceAmount = experienceAmount;
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
