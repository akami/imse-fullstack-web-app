package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class SkinReport
{
    private int characterClassId;
    private int skinId;
    private String skinName;
    private int boughtAmount;

    public SkinReport(int characterClassId, int skinId, String skinName, int boughtAmount)
    {
        this.characterClassId = characterClassId;
        this.skinId = skinId;
        this.skinName = skinName;
        this.boughtAmount = boughtAmount;
    }

    public int getCharacterClassId() {
        return characterClassId;
    }

    public int getSkinId() {
        return skinId;
    }

    public String getSkinName() {
        return skinName;
    }

    public int getBoughtAmount() {
        return boughtAmount;
    }

    @Override
    public String toString() {
        return "SkinReport{" +
                "chracterClassId=" + characterClassId +
                ", skinId=" + skinId +
                ", skinName='" + skinName + '\'' +
                ", boughtAmount=" + boughtAmount +
                '}';
    }
}
