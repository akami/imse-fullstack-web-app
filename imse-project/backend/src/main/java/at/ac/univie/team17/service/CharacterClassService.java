package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterClassQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClassReport;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterClassQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClass;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClassReport;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterClassService {
    public List<CharacterClass> getCharacterClasses() {
        String query = CharacterClassQueries.getSelectAllCharacterClassesQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterClass> classes = MariaDBResultReader.getCharacterClassesFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return classes;
    }

    public List<MongoCharacterClass> getMongoCharacterClasses()
    {
        MongoDBConnectionHandler.setupConnection();
        List<MongoCharacterClass> classes = MongoCharacterClassQueries.getCharacterClasses();
        MongoDBConnectionHandler.closeConnection();
        return classes;
    }

    public List<CharacterClassReport> getCharacterClassReport()
    {
        String query = CharacterClassQueries.getClassReportQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterClassReport> classReports = MariaDBResultReader.getCharacterClassReportsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return classReports;
    }

    public List<MongoCharacterClassReport> getMongoCharacterClassReport() {
        List<MongoCharacterClassReport> mongoCharacterClassReports = MongoCharacterQueries.getMongoCharacterClassReports();
        return mongoCharacterClassReports;
    }
}
