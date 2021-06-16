package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;

import java.util.ArrayList;

public class MongoMonster
{
    private int monsterId;
    private String monsterName;
    private int attack;
    private int lifepointAmount;
    private int challengeRating;
    private MonsterLoot monsterLoot;
    private ArrayList<MongoMonster> possibleAlliedMonsters;

    public MongoMonster(int monsterId, String monsterName, int attack, int lifepointAmount, int challengeRating,
                        MonsterLoot monsterLoot, ArrayList<MongoMonster> possibleAlliedMonsters)
    {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
        this.challengeRating = challengeRating;
        this.monsterLoot = monsterLoot;
        this.possibleAlliedMonsters = possibleAlliedMonsters;
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

    public MonsterLoot getMonsterLoot()
    {
        return monsterLoot;
    }

    public ArrayList<MongoMonster> getPossibleAlliedMonsters()
    {
        return possibleAlliedMonsters;
    }
}
