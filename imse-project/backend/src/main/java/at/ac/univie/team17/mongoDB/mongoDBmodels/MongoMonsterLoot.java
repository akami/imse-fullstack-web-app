package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoMonsterLoot
{
    private int goldAmount;
    private int experienceAmount;

    public MongoMonsterLoot(int goldAmount, int experienceAmount)
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
