package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterClassDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.SkinDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterSlayedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.print.Doc;
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

    public static List<MongoSkin> getAvailableMongoSkinsFromCharacterId(Integer characterId)
    {
        final List<MongoSkin>[] mongoCharacterSkins = new List[]{new ArrayList<>()};
        final List<MongoSkin>[] allClassSkins =  new List[]{new ArrayList<>()};

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME)
                .find(eq("_id", characterId)).projection(Projections.include("characterClass", "boughtSkins")).
                forEach((Block<Document>) document ->
                {
                    mongoCharacterSkins[0] = (SkinDocumentCreator.getSkinsFromDocument((ArrayList<Document>) document.get("boughtSkins")));
                    allClassSkins[0] = CharacterClassDocumentCreator.getCharacterClassFromDocument(
                            (Document) document.get("characterClass")).getSkins();
                });

        MongoDBConnectionHandler.closeConnection();

        allClassSkins[0].removeAll(mongoCharacterSkins[0]);
        return allClassSkins[0];
    }

    public static void addBoughtSkinToCharacter(Integer characterId, MongoSkin mongoSkin)
    {
        Document skinDoc = SkinDocumentCreator.createSkinDocument(mongoSkin);

        MongoDBConnectionHandler.setupConnection();
        MongoDBConnectionHandler.getDb().getCollection(CharacterDocumentCreator.CHARACTER_COLLECTION_NAME).updateOne(
                eq("_id", characterId), Updates.push("Data", skinDoc));

        MongoDBConnectionHandler.closeConnection();
    }
}
