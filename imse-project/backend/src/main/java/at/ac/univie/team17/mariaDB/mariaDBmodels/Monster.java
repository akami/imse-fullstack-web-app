package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Monster
{
    private int monsterId;
    private String monsterName;
    private int attack;
    private int lifepointAmount;
    private int challengeRating;

    public Monster(int monsterId, String monsterName, int attack, int lifepointAmount, int challengeRating)
    {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
        this.challengeRating = challengeRating;
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
}
