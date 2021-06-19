package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayerPet;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


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

    public static List<MongoCharacter> getMongoCharactersFromPlayer(Integer playerId)
    {
        MongoDBConnectionHandler.setupConnection();

        final List<MongoCharacter>[] mongoCharacters = new List[]{new ArrayList<>()};

        MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME)
                .find(eq("_id", playerId)).projection(Projections.include("characters")).forEach((Block<Document>) document ->
                mongoCharacters[0] = (PlayerDocumentCreator.getMongoPlayerWithCharactersFromDocument(document).getCreatedCharacters()));

        MongoDBConnectionHandler.closeConnection();

        return mongoCharacters[0];
    }

    public static void insertMongoCharacterInPlayer(Document mongoCharacter, Integer playerId)
    {
        MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME)
                .findOneAndUpdate(eq("_id", playerId), Updates.push("characters", mongoCharacter));
    }

    public static List<MongoGoldOffer> getMongoGoldOffersFromPlayer(int playerId)
    {
        MongoDBConnectionHandler.setupConnection();

        final List<MongoGoldOffer>[] mongoGoldOffers = new List[]{new ArrayList<>()};

        MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME)
                .find(eq("_id", playerId)).projection(Projections.include("goldOffers")).forEach((Block<Document>) document ->
                mongoGoldOffers[0] = (PlayerDocumentCreator.getMongoPlayerWithGoldOffersFromDocument(document).getGoldOffers()));

        MongoDBConnectionHandler.closeConnection();

        return mongoGoldOffers[0];
    }

    public static List<MongoPlayerPet> getMongoPlayerPets()
    {
        List<MongoPlayerPet> mongoPlayerPets = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME)
                .find().projection(Projections.include("_id", "boughtPets")).forEach((Block<Document>)document ->
                {
                    MongoPlayer mongoPlayer = PlayerDocumentCreator.getMongoPlayerWithPetsFromDocument(document);
                    mongoPlayerPets.add(new MongoPlayerPet(mongoPlayer.getPlayerId(), mongoPlayer.getBoughtPets()));
                });


        MongoDBConnectionHandler.closeConnection();
        return mongoPlayerPets;
    }
}
