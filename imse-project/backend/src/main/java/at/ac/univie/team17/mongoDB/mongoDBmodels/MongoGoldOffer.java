package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;

import java.util.ArrayList;

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

    public static ArrayList<MongoGoldOffer> getMongoGoldOffersFromGoldOffers(ArrayList<GoldOffer> goldOffers)
    {
        ArrayList<MongoGoldOffer> mongoGoldOffers = new ArrayList<>();
        for (GoldOffer goldOffer : goldOffers)
        {
            mongoGoldOffers.add(new MongoGoldOffer(goldOffer.isAccepted(), goldOffer.isSuccessful(), goldOffer.getGoldAmount()));
        }
        return mongoGoldOffers;
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
