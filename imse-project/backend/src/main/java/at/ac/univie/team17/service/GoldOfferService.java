package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.GoldOfferQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
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
}
