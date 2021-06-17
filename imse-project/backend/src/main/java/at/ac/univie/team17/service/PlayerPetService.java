package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PetQueries;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerPetQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.PlayerPet;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerPetService {
    public List<PlayerPet> getPlayerPets() {
        String query = PlayerPetQueries.getSelectAllPlayerPetsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<PlayerPet> playerPets = MariaDBResultReader.getPlayerPetsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return playerPets;
    }
}
