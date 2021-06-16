package at.ac.univie.team17.mongoDB;

import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PetDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import com.mongodb.client.MongoDatabase;

public class MongoDBCollectionDropper
{
    public static void dropMongoDBCollections(MongoDatabase db)
    {
        MongoDBExecuter.deleteCollection(db, PetDocumentCreator.PET_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, PlayerDocumentCreator.PLAYER_COLLECTION_NAME);
    }
}
