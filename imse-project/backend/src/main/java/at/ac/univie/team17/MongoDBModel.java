package at.ac.univie.team17;

import org.springframework.stereotype.Component;
import at.ac.univie.team17.mongoDB.MongoDBCollectionDropper;

@Component
public class MongoDBModel
{
    public MongoDBModel()
    {
        MongoDBConnectionHandler.setupConnection();

        MongoDBCollectionDropper.dropMongoDBCollections(MongoDBConnectionHandler.getDb());

        MariaDBConnectionHandler.setupConnection();
        DataMigrator.migrateData(MariaDBConnectionHandler.getStatement(), MongoDBConnectionHandler.getDb());
        MariaDBConnectionHandler.closeConnection();

        MongoDBConnectionHandler.closeConnection();
    }
}
