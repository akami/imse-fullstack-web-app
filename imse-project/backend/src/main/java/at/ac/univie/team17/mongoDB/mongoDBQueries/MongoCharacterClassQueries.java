package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterClassDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.*;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoCharacterClassQueries
{

    public static Document getCharacterClassFromId(int characterClassId)
    {
        final Document[] characterClass = new Document[1];
        MongoDBConnectionHandler.getDb().getCollection(CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME)
                .find(eq("_id", characterClassId)).forEach((Block<Document>) document -> characterClass[0] = document);
        return characterClass[0];
    }

    public static List<MongoCharacterClass> getCharacterClasses()
    {
        List<MongoCharacterClass> classes = new ArrayList<>();
        MongoDBConnectionHandler.getDb().getCollection(CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME)
                .find().forEach((Block<Document>) document -> classes.add(CharacterClassDocumentCreator.getCharacterClassFromDocument(document)));
        return classes;
    }

    public static List<CharacterClassMongoSkins> getAllMongoSkins()
    {
        List<CharacterClassMongoSkins> mongoSkins = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME)
                .find().projection(Projections.include("_id", "skins")).forEach((Block<Document>) document ->
        {
            MongoCharacterClass characterClass = CharacterClassDocumentCreator.getCharacterClassWithSkinsFromDocument(document);
            mongoSkins.add(new CharacterClassMongoSkins(characterClass.getClassId(), characterClass.getSkins()));
        });

        MongoDBConnectionHandler.closeConnection();
        return mongoSkins;
    }

    public static List<MongoSkin> getMongoSkinsFromClassId(Integer classId)
    {
        final List<MongoSkin>[] mongoSkins = new List[]{new ArrayList<>()};

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME)
                .find(eq("_id", classId)).projection(Projections.include("skins")).forEach((Block<Document>) document ->
        {
            mongoSkins[0] = CharacterClassDocumentCreator.getSkinsFromCharacterClassFromDocument(document);
        });

        MongoDBConnectionHandler.closeConnection();
        return mongoSkins[0];
    }
}
