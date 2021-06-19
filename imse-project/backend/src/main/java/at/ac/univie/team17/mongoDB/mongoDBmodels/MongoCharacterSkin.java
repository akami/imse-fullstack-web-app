package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.List;

public class MongoCharacterSkin
{
    private int characterId;
    List<MongoSkin> boughtSkins;

    public MongoCharacterSkin(int characterId, List<MongoSkin> boughtSkins)
    {
        this.characterId = characterId;
        this.boughtSkins = boughtSkins;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public List<MongoSkin> getBoughtSkins()
    {
        return boughtSkins;
    }
}
