package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;

import java.util.ArrayList;

public class MongoSkin
{
    private int skinId;
    private String skinName;
    private int goldPrice;

    public MongoSkin(int skinId, String skinName, int goldPrice)
    {
        this.skinId = skinId;
        this.skinName = skinName;
        this.goldPrice = goldPrice;
    }

    public int getSkinId()
    {
        return skinId;
    }

    public String getSkinName()
    {
        return skinName;
    }

    public int getGoldPrice()
    {
        return goldPrice;
    }

    public static ArrayList<MongoSkin> getMongoSkinsFromSkin(ArrayList<Skin> skins)
    {
        ArrayList<MongoSkin> mongoClassSkins = new ArrayList<>();
        for (Skin skin : skins)
        {
            mongoClassSkins.add(MongoSkin.getMongoSkinFromSkin(skin));
        }
        return mongoClassSkins;
    }

    private static MongoSkin getMongoSkinFromSkin(Skin skin)
    {
        return new MongoSkin(skin.getSkinId(), skin.getSkinName(), skin.getGoldPrice());
    }
}
