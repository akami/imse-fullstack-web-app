package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import org.bson.Document;
import java.util.ArrayList;

public class PlayerDocumentCreator
{
    public static final String PLAYER_COLLECTION_NAME = "player";

    public static Document createPlayerDocument(Player player, ArrayList<MongoGoldOffer> goldOffers, ArrayList<Document> boughtPets,
                                                ArrayList<Document> characters)
    {
        Document playerDocument = new Document();
        playerDocument.append("_id", player.getPlayerId());
        playerDocument.append("username", player.getUsername());
        playerDocument.append("age", player.getAge());
        playerDocument.append("emailAddress", player.getEmailAddress());
        playerDocument.append("goldOffers", GoldOfferDocumentCreator.createGoldOfferDocuments(goldOffers));
        playerDocument.append("boughtPets", boughtPets);
        playerDocument.append("characters", characters);
        return playerDocument;
    }
}
