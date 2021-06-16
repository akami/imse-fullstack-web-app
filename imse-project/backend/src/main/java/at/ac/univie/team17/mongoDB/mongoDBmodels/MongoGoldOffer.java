package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoGoldOffer
{
    private boolean accepted;
    private boolean successful;
    private int goldAmount;

    public MongoGoldOffer(boolean accepted, boolean successful, int goldAmount)
    {
        this.accepted = accepted;
        this.successful = successful;
        this.goldAmount = goldAmount;
    }

    public boolean isAccepted()
    {
        return accepted;
    }

    public boolean isSuccessful()
    {
        return successful;
    }

    public int getGoldAmount()
    {
        return goldAmount;
    }
}
