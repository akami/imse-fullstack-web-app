package at.ac.univie.team17.mongoDB;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDBExecuter
{
    public static void insertDocument(MongoDatabase db, Document documentToInsert, String collectionName)
    {
        db.getCollection(collectionName).insertOne(documentToInsert);
    }

    public static void insertDocuments(MongoDatabase db, ArrayList<Document> documentsToInsert, String collectionName)
    {
        db.getCollection(collectionName).insertMany(documentsToInsert);
    }

    public static void deleteCollection(MongoDatabase db, String collectionName)
    {
        db.getCollection(collectionName).drop();
    }
}
