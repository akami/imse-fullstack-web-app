package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;

public class GoldOfferQueries
{
    public static String getInsertGoldOfferQuery(GoldOffer goldOffer)
    {
        return "INSERT INTO gold_offer(accepted, successful, gold_amount, player_id) VALUES (" + goldOffer.isAccepted() +
                ", " + goldOffer.isSuccessful() + ", '" + goldOffer.getGoldAmount() + "', '" + goldOffer.getPlayerId() + "');";
    }

    public static String getSelectAllGoldOffersQuery()
    {
        return "SELECT * FROM gold_offer;";
    }

    public static String getSelectGoldOfferFromIdQuery(int id)
    {
        return "SELECT * FROM gold_offer WHERE gold_offer_id = " + id + ";";
    }

    public static String getSelectedGoldOffersFromPlayerIdQuery(int playerId)
    {
        return "SELECT * FROM gold_offer WHERE player_id = " + playerId + ";";
    }

    public static String getCreateGoldOfferTableQuery()
    {
        return "CREATE TABLE gold_offer(gold_offer_id INT AUTO_INCREMENT, accepted BOOLEAN, successful BOOLEAN, gold_amount INT, " +
                "player_id INT, PRIMARY KEY (gold_offer_id), CONSTRAINT gold_offer_fk_player FOREIGN KEY (player_id) REFERENCES " +
                "player(player_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropGoldOfferClassTableQuery()
    {
        return "DROP TABLE gold_offer;";
    }
}
