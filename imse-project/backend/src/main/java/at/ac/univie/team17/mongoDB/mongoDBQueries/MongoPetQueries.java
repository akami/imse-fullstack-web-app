package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PetDocumentCreator;
import at.ac.univie.team17.sharedDataModels.Pet;
import com.mongodb.Block;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoPetQueries
{
    public static List<Pet> getMongoPets()
    {
        List<Pet> pets = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(PetDocumentCreator.PET_COLLECTION_NAME)
                .find().forEach((Block<Document>) document ->
                pets.add(PetDocumentCreator.getPetFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return pets;
    }
}
