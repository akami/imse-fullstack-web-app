package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.AlliedMonstersQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.AlliedMonsters;
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
}
