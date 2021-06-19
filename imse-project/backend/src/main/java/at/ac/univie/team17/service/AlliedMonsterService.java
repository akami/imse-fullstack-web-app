package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.AlliedMonstersQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.AlliedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoMonsterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoAlliedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlliedMonsterService {

    public List<AlliedMonsters> getAlliedMonsters() {
        String query = AlliedMonstersQueries.getSelectAllAlliedMonstersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<AlliedMonsters> alliedMonsters = MariaDBResultReader.getAlliedMonstersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return alliedMonsters;
    }

    public List<MongoAlliedMonsters> getMongoAlliedMonsters()
    {
        List<MongoAlliedMonsters> alliedMonsters = MongoMonsterQueries.getMongoAlliedMonsters();
        return alliedMonsters;
    }
}
