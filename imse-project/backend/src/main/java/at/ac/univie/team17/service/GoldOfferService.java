package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.GoldOfferQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoldOfferService {
    public List<GoldOffer> getGoldOffersByPlayerId(int playerId) {
        String query = GoldOfferQueries.getSelectedGoldOffersFromPlayerIdQuery(playerId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<GoldOffer> goldOffers = MariaDBResultReader.getGoldOffersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return goldOffers;
    }

    public List<MongoGoldOffer> getMongoGoldOffersByPlayerId(int playerId)
    {
        List<MongoGoldOffer> goldOffers = MongoPlayerQueries.getMongoGoldOffersFromPlayer(playerId);
        return goldOffers;
    }

    public void addGoldOfferToPlayer(Integer playerId, GoldOffer goldOffer)
    {
        String query = GoldOfferQueries.getInsertGoldOfferQuery(goldOffer);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public void addMongoGoldOfferToMongoPlayer(Integer playerId, MongoGoldOffer goldOffer)
    {
        MongoPlayerQueries.insertMongoGoldOfferInPlayer(playerId, goldOffer);
    }

    public GoldOffer getPersonalizedGoldOffer(Integer playerId)
    {
        List<GoldOffer> playerOffers = getGoldOffersByPlayerId(playerId);
        int acceptedAmount = 0, goldAmount = 0, notAcceptedAmount = 0;
        for (GoldOffer goldOffer : playerOffers)
        {
            if (goldOffer.isAccepted())
            {
                ++acceptedAmount;
                goldAmount += goldOffer.getGoldAmount();
            }
            else
            {
                ++notAcceptedAmount;
            }
        }
        if (acceptedAmount == 0 || goldAmount == 0 || notAcceptedAmount == 0)
        {
            return new GoldOffer(0, false, false, 15, playerId);
        }

        return new GoldOffer(0, false, false,
                getPersonalizedGoldAmount(goldAmount, notAcceptedAmount), playerId);
    }

    private int getPersonalizedGoldAmount(int goldAmount, int notAcceptedAmount)
    {
        return goldAmount / notAcceptedAmount;
        // gekürzt von  acceptedAmount/notAcceptedAmount * goldAmount/acceptedAmount
    }

    public MongoGoldOffer getPersonalizedMongoGoldOffer(Integer playerId)
    {
        List<MongoGoldOffer> goldOffers = MongoPlayerQueries.getMongoGoldOffersFromPlayer(playerId);

        int acceptedAmount = 0, goldAmount = 0, notAcceptedAmount = 0;
        for (MongoGoldOffer goldOffer : goldOffers)
        {
            if (goldOffer.isAccepted())
            {
                ++acceptedAmount;
                goldAmount += goldOffer.getGoldAmount();
            }
            else
            {
                ++notAcceptedAmount;
            }
        }
        if (acceptedAmount == 0 || goldAmount == 0 || notAcceptedAmount == 0)
        {
            return new MongoGoldOffer(false, false, 15);
        }

        return new MongoGoldOffer(false, false, getPersonalizedGoldAmount(goldAmount, notAcceptedAmount));
    }
}