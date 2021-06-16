package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.ArrayList;

public class MongoCharacterClass
{
    private int classId;
    private int bonusAttack;
    private int bonusLifepoints;
    private String className;
    private ArrayList<MongoSkin> skins;

    public MongoCharacterClass(int classId, int bonusAttack, int bonusLifepoints, String className, ArrayList<MongoSkin> skins)
    {
        this.classId = classId;
        this.bonusAttack = bonusAttack;
        this.bonusLifepoints = bonusLifepoints;
        this.className = className;
        this.skins = skins;
    }

    public int getClassId()
    {
        return classId;
    }

    public int getBonusAttack()
    {
        return bonusAttack;
    }

    public int getBonusLifepoints()
    {
        return bonusLifepoints;
    }

    public String getClassName()
    {
        return className;
    }

    public ArrayList<MongoSkin> getSkins()
    {
        return skins;
    }
}
