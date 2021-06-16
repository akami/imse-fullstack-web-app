package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import org.bson.Document;

public class PlayerDocumentCreator
{
    public static final String PLAYER_COLLECTION_NAME = "player";

    public static Document createPlayerDocument(MongoPlayer mongoPlayer)
    {
        Document playerDocument = new Document();
        playerDocument.append("_id", mongoPlayer.getPlayerId());
        playerDocument.append("username", mongoPlayer.getUsername());
        playerDocument.append("age", mongoPlayer.getAge());
        playerDocument.append("emailAddress", mongoPlayer.getEmailAddress());
        playerDocument.append("goldOffers", mongoPlayer.getGoldOffers());
        playerDocument.append("boughtPets", mongoPlayer.getBoughtPets());
        playerDocument.append("characters", mongoPlayer.getCreatedCharacters());
        return playerDocument;
    }
}
