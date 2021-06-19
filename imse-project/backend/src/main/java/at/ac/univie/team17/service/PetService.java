package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PetQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoMonsterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPetQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PetService {
    public List<Pet> getPets() {
        String query = PetQueries.getSelectAllPetsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Pet> pets = MariaDBResultReader.getPetFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return pets;
    }

    public List<Pet> getMongoPets()
    {
        List<Pet> pets = MongoPetQueries.getMongoPets();
        return pets;
    }
}
