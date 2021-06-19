package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.MonsterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoAlliedMonsters;
import com.mongodb.Block;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoMonsterQueries
{
    public static List<MongoAlliedMonsters> getMongoAlliedMonsters()
    {
        List<MongoAlliedMonsters> mongoAlliedMonsters = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(MonsterDocumentCreator.MONSTER_COLLECTION_NAME)
                .find().forEach((Block<Document>) document ->
                mongoAlliedMonsters.add(MonsterDocumentCreator.getAlliedMonstersFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoAlliedMonsters;
    }
}
