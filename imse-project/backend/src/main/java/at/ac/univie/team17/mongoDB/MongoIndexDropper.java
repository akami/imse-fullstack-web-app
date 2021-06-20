package at.ac.univie.team17.mongoDB;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import com.mongodb.client.model.Indexes;

public class MongoIndexDropper
{

    public static void dropIndices()
    {
        try
        {
            MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME).dropIndex(
                    Indexes.ascending("playerAge.age"));

            MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME).dropIndex(
                    Indexes.ascending("username", "emailAddress"));

            MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME).dropIndex(
                    Indexes.ascending("goldOffers.successful"));

            MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME).
                    dropIndex(Indexes.ascending("slayedMonsters.slayAmount"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
