package at.ac.univie.team17;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Component;

@Component
public class MongoDBModel
{
    private MongoClient mongoClient = null;

    public MongoDBModel()
    {
        setupConnection();
        closeConnection();
    }

    private void setupConnection()
    {
        try
        {
            // Creating a Mongo client
            this.mongoClient = new MongoClient("localhost", 27017);

            //Accessing the database
            MongoDatabase mongoDatabase = this.mongoClient.getDatabase("db");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void closeConnection()
    {
        this.mongoClient.close();
    }
}
