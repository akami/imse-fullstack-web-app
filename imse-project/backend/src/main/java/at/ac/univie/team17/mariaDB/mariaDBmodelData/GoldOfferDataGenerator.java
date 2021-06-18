package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;

import java.util.ArrayList;
import java.util.Random;

public class GoldOfferDataGenerator
{
    private static final int GOLD_RANGE = 30;
    private static final int MINIMAL_GOLD = 10;

    public static ArrayList<GoldOffer> generateGoldOfferData(int goldOfferAmount, int playerAmount)
    {
        ArrayList<GoldOffer> goldOffers = new ArrayList<>();

        Random random = new Random();
        boolean accepted, successful = false;

        for (int i = 0; i < goldOfferAmount; ++i)
        {
            accepted = random.nextBoolean();
            if (accepted)
            {
                successful = random.nextBoolean();
            }
            goldOffers.add(new GoldOffer(i, accepted, successful,random.nextInt(GOLD_RANGE) + MINIMAL_GOLD,
                    random.nextInt(playerAmount) + 1));
        }
        return goldOffers;
    }
}
