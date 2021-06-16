package at.ac.univie.team17;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionHandler
{
    private static MongoClient mongoClient = null;
    private static MongoDatabase db;

    public static void setupConnection()
    {
        try
        {
            // Creating a Mongo client
            mongoClient = new MongoClient("localhost", 27017);

            //Accessing the database
            db = mongoClient.getDatabase("db");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void closeConnection()
    {
        mongoClient.close();
    }

    public static MongoDatabase getDb()
    {
        return db;
    }
}
