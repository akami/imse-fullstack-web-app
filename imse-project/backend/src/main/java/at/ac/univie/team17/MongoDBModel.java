package at.ac.univie.team17;

import at.ac.univie.team17.mongoDB.MongoDBCollectionDropper;

public class MongoDBModel
{
    public static void initialize()
    {
        clear();

        MongoDBConnectionHandler.setupConnection();

        MariaDBConnectionHandler.setupConnection();
        DataMigrator.migrateData(MariaDBConnectionHandler.getStatement(), MongoDBConnectionHandler.getDb());
        MariaDBConnectionHandler.closeConnection();

        // TODO create indices

        MongoDBConnectionHandler.closeConnection();
    }

    public static void clear()
    {
        MongoDBConnectionHandler.setupConnection();
        MongoDBCollectionDropper.dropMongoDBCollections(MongoDBConnectionHandler.getDb());
        MongoDBConnectionHandler.closeConnection();
    }
}
