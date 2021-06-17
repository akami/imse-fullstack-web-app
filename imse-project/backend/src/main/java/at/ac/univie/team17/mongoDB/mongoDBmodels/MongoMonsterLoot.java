package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;

public class MongoMonsterLoot
{
    private int goldAmount;
    private int experienceAmount;

    public MongoMonsterLoot(int goldAmount, int experienceAmount)
    {
        this.goldAmount = goldAmount;
        this.experienceAmount = experienceAmount;
    }

    public static MongoMonsterLoot getMongoMonsterLootFromMonsterLoot(MonsterLoot monsterLoot)
    {
        return new MongoMonsterLoot(monsterLoot.getGoldAmount(), monsterLoot.getExperienceAmount());
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
