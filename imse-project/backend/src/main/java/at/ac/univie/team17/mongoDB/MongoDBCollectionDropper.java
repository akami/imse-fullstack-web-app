package at.ac.univie.team17.mongoDB;

import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.*;
import com.mongodb.client.MongoDatabase;

public class MongoDBCollectionDropper
{
    public static void dropMongoDBCollections(MongoDatabase db)
    {
        MongoDBExecuter.deleteCollection(db, MonsterDocumentCreator.MONSTER_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, QuestDocumentCreator.QUEST_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, CharacterDocumentCreator.CHARACTER_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, PetDocumentCreator.PET_COLLECTION_NAME);
        MongoDBExecuter.deleteCollection(db, PlayerDocumentCreator.PLAYER_COLLECTION_NAME);
    }
}
