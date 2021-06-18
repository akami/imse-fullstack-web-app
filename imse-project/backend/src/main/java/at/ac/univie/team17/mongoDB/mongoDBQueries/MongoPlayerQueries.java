package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import com.mongodb.Block;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoPlayerQueries
{

    public static List<MongoPlayer> getMongoPlayers()
    {
        List<MongoPlayer> mongoPlayers = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME)
                .find().forEach((Block<Document>)document ->
                mongoPlayers.add(PlayerDocumentCreator.getMongoPlayerFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoPlayers;
    }
}
