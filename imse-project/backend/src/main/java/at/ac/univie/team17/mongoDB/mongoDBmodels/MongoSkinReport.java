package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoSkinReport
{
    private int skinId;
    private int boughtAmount;

    public MongoSkinReport(int skinId, int boughtAmount) {
        this.skinId = skinId;
        this.boughtAmount = boughtAmount;
    }

    @Override
    public String toString() {
        return "MongoSkinReport{" +
                "skinId=" + skinId +
                ", boughtAmount=" + boughtAmount +
                '}';
    }

    public int getSkinId() {
        return skinId;
    }

    public int getBoughtAmount() {
        return boughtAmount;
    }
}
