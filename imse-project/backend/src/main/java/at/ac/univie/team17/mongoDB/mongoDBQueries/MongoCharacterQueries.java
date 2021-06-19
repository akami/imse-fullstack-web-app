package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterSlayedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoCharacterQueries
{
    public static List<MongoCharacter> getMongoCharacters()
    {
        List<MongoCharacter> mongoCharacters = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME)
                .find().forEach((Block<Document>) document ->
                mongoCharacters.add(CharacterDocumentCreator.getCharacterFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoCharacters;
    }

    public static List<CharacterSlayedMonsters> getCharacterSlayedMonsters()
    {
        List<CharacterSlayedMonsters> characterSlayedMonsters = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME)
                .find().projection(Projections.include("_id", "slayedMonsters")).forEach((Block<Document>) document ->
                characterSlayedMonsters.add(CharacterDocumentCreator.getCharacterSlayedMonstersFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return characterSlayedMonsters;
    }

    public static List<MongoCharacterSkin> getCharacterSkins()
    {
        List<MongoCharacterSkin> mongoCharacterSkins = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME)
                .find().projection(Projections.include("_id", "boughtSkins")).forEach((Block<Document>) document ->
                mongoCharacterSkins.add(CharacterDocumentCreator.getCharacterSkinsFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoCharacterSkins;
    }

    public static List<MongoCharacterSkin> getCharacterSkinsFromCharacterId(Integer characterId)
    {
        List<MongoCharacterSkin> mongoCharacterSkins = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME)
                .find(eq("_id", characterId)).projection(Projections.include("_id", "boughtSkins")).
                forEach((Block<Document>) document -> mongoCharacterSkins.add(CharacterDocumentCreator.
                        getCharacterSkinsFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoCharacterSkins;
    }
}
