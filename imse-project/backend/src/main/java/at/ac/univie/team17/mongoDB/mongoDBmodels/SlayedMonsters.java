package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.Objects;

public class SlayedMonsters
{
    private int monsterId;
    private MongoMonsterLoot monsterLoot;
    private int slayAmount;

    public SlayedMonsters(int monsterId, MongoMonsterLoot monsterLoot, int slayAmount)
    {
        this.monsterId = monsterId;
        this.monsterLoot = monsterLoot;
        this.slayAmount = slayAmount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlayedMonsters that = (SlayedMonsters) o;
        return monsterId == that.monsterId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(monsterId);
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public MongoMonsterLoot getMonsterLoot()
    {
        return monsterLoot;
    }

    public int getSlayAmount()
    {
        return slayAmount;
    }

    public void increaseSlayAmount()
    {
        ++slayAmount;
    }
}
