package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerPetQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.PlayerPet;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayerPet;

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

    public List<MongoPlayerPet> getMongoPlayerPets()
    {
        List<MongoPlayerPet> mongoPlayerPets = MongoPlayerQueries.getMongoPlayerPets();
        return mongoPlayerPets;
    }
}
