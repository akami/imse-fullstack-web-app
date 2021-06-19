package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.ArrayList;

public class CharacterClassMongoSkins
{
    private int classId;
    private ArrayList<MongoSkin> skins;

    public CharacterClassMongoSkins(int classId, ArrayList<MongoSkin> skins)
    {
        this.classId = classId;
        this.skins = skins;
    }

    public int getClassId()
    {
        return classId;
    }

    public ArrayList<MongoSkin> getSkins()
    {
        return skins;
    }
}
