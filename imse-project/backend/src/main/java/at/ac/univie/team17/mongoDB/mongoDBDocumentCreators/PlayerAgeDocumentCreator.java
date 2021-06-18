package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.PlayerAge;
import org.bson.Document;

public class PlayerAgeDocumentCreator
{
    public static Document getPlayerAgeDocument(PlayerAge playerAge)
    {
        Document playerAgeDocument = new Document();
        playerAgeDocument.append("_id", playerAge.getPlayerId());
        playerAgeDocument.append("age", playerAge.getAge());
        return playerAgeDocument;
    }

    public static PlayerAge getPlayerAgeFromDocument(Document document)
    {
        return new PlayerAge(document.getInteger("_id"), document.getInteger("age"));
    }
}
