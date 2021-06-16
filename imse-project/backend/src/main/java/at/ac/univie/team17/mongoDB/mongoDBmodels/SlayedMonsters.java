package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;

public class SlayedMonsters
{
    private int monsterId;
    private MonsterLoot monsterLoot;
    private int slayAmount;

    public SlayedMonsters(int monsterId, MonsterLoot monsterLoot, int slayAmount)
    {
        this.monsterId = monsterId;
        this.monsterLoot = monsterLoot;
        this.slayAmount = slayAmount;
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public MonsterLoot getMonsterLoot()
    {
        return monsterLoot;
    }

    public int getSlayAmount()
    {
        return slayAmount;
    }
}
