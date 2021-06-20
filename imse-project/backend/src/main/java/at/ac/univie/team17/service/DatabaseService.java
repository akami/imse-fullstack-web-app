package at.ac.univie.team17.service;

import at.ac.univie.team17.ActiveDatabase;
import at.ac.univie.team17.MariaDBModel;
import at.ac.univie.team17.MongoDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {
    @Autowired
    private ActiveDatabase activeDatabase;

    public void initialize() {
        MariaDBModel.initialize();
        System.out.println("Mariadb initialized");
    }

    public void clear() {
        if (activeDatabase.isMariadbActive())
        {
            MariaDBModel.clear();
            System.out.println("MariaDB cleared");
        } else
        {
            MongoDBModel.clear();
            System.out.println("MongoDB cleared");
        }
    }

    public void migrate() {
        MongoDBModel.initialize();
        activeDatabase.migrate();
        System.out.println("Migrated to MongoDB");
    }
}
