package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.ArrayList;

public class MongoMonster
{
    private int monsterId;
    private String monsterName;
    private int attack;
    private int lifepointAmount;
    private int challengeRating;
    private MongoMonsterLoot monsterLoot;
    private ArrayList<Integer> possibleAlliedMonsters;

    public MongoMonster(int monsterId, String monsterName, int attack, int lifepointAmount, int challengeRating,
                        MongoMonsterLoot monsterLoot, ArrayList<Integer> possibleAlliedMonsters)
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

    public MongoMonsterLoot getMonsterLoot()
    {
        return monsterLoot;
    }

    public ArrayList<Integer> getPossibleAlliedMonsters()
    {
        return possibleAlliedMonsters;
    }
}
