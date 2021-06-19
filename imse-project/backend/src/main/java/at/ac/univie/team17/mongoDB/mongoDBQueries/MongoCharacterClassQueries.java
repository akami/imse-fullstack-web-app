package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterClassDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClass;
import com.mongodb.Block;
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
}
