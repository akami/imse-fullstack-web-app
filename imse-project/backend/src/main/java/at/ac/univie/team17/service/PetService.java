package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PetQueries;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PetService {
    public void savePet(Pet pet) {
        // TODO @kh save pet
    }

    public List<Pet> getPets() {
        String query = PetQueries.getSelectAllPetsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Pet> pets = MariaDBResultReader.getPetFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return pets;
    }
}
