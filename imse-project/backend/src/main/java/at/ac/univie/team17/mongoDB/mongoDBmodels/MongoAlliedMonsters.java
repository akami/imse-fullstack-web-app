package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.ArrayList;

public class MongoAlliedMonsters
{
    private int monsterId;
    private ArrayList<Integer> possibleAlliedMonsters;

    public MongoAlliedMonsters(int monsterId, ArrayList<Integer> possibleAlliedMonsters)
    {
        this.monsterId = monsterId;
        this.possibleAlliedMonsters = possibleAlliedMonsters;
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public ArrayList<Integer> getPossibleAlliedMonsters()
    {
        return possibleAlliedMonsters;
    }
}
