package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Monster
{
    private int monsterId;
    private String monsterName;
    private int attack;
    private int lifepointAmount;
    private int challengeRating;
    private int monsterLootId;

    public Monster(int monsterId, String monsterName, int attack, int lifepointAmount, int challengeRating, int monsterLootId)
    {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
        this.challengeRating = challengeRating;
        this.monsterLootId = monsterLootId;
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public String getMonsterName()
    {
        return monsterName;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getLifepointAmount()
    {
        return lifepointAmount;
    }

    public int getChallengeRating()
    {
        return challengeRating;
    }

    public int getMonsterLootId()
    {
        return monsterLootId;
    }
}
