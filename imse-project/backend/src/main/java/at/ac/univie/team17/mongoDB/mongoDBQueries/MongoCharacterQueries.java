package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import com.mongodb.Block;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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
}
