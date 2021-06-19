package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.MonsterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoAlliedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLoot;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLootWithIds;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
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

    public static List<MongoMonster> getMongoMonsters() {
        List<MongoMonster> mongoMonsters = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(MonsterDocumentCreator.MONSTER_COLLECTION_NAME).find().
                forEach((Block<Document>) document -> mongoMonsters.add(MonsterDocumentCreator.getMonsterFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoMonsters;
    }

    public static List<MongoMonsterLootWithIds> getMongoMonsterLootWithIds()
    {
        List<MongoMonsterLootWithIds> mongoMonsters = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(MonsterDocumentCreator.MONSTER_COLLECTION_NAME).find().
                forEach((Block<Document>) document ->
                {
                    MongoMonster mongoMonster = MonsterDocumentCreator.getMonsterFromDocument(document);
                    mongoMonsters.add(new MongoMonsterLootWithIds(mongoMonster.getMonsterId(), mongoMonster.getMonsterLoot()));
                });

        MongoDBConnectionHandler.closeConnection();
        return mongoMonsters;
    }
}

