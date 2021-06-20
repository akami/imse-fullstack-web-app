package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class SkinReport
{
    private int chracterClassId;
    private int skinId;
    private String skinName;
    private int boughtAmount;

    public SkinReport(int chracterClassId, int skinId, String skinName, int boughtAmount)
    {
        this.chracterClassId = chracterClassId;
        this.skinId = skinId;
        this.skinName = skinName;
        this.boughtAmount = boughtAmount;
    }

    public int getChracterClassId() {
        return chracterClassId;
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
                "chracterClassId=" + chracterClassId +
                ", skinId=" + skinId +
                ", skinName='" + skinName + '\'' +
                ", boughtAmount=" + boughtAmount +
                '}';
    }
}
