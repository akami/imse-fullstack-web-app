package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class MonsterLoot
{
    private int lootId;
    private int goldAmount;
    private int experienceAmount;

    public MonsterLoot(int lootId, int goldAmount, int experienceAmount)
    {
        this.lootId = lootId;
        this.goldAmount = goldAmount;
        this.experienceAmount = experienceAmount;
    }

    public int getLootId()
    {
        return lootId;
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
