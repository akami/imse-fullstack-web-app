package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.GoldOfferQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoldOfferService {
    public void saveGoldOffer(GoldOffer goldOffer) {
        String query = GoldOfferQueries.getInsertGoldOfferQuery(goldOffer);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<GoldOffer> getGoldOffersByPlayerId(int playerId) {
        String query = GoldOfferQueries.getSelectedGoldOffersFromPlayerIdQuery(playerId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<GoldOffer> goldOffers = MariaDBResultReader.getGoldOffersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return goldOffers;
    }

}
