package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Skin
{
    private int skinId;
    private int classId;
    private String skinName;
    private int goldPrice;

    public Skin(int skinId, int classId, String skinName, int goldPrice)
    {
        this.skinId = skinId;
        this.classId = classId;
        this.skinName = skinName;
        this.goldPrice = goldPrice;
    }

    public int getSkinId()
    {
        return skinId;
    }

    public int getClassId()
    {
        return classId;
    }

    public String getSkinName()
    {
        return skinName;
    }

    public int getGoldPrice()
    {
        return goldPrice;
    }
}
