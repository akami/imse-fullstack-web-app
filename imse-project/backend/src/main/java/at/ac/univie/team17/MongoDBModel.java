package at.ac.univie.team17;

import at.ac.univie.team17.mongoDB.MongoDBCollectionDropper;

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
