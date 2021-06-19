package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoMonsterLootWithIds
{
    private int monsterId;
    private MongoMonsterLoot monsterLoot;

    public MongoMonsterLootWithIds(int monsterId, MongoMonsterLoot monsterLoot)
    {
        this.monsterId = monsterId;
        this.monsterLoot = monsterLoot;
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public MongoMonsterLoot getMonsterLoot()
    {
        return monsterLoot;
    }
}
