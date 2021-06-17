package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.AlliedMonstersQueries;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlliedMonsterService {
    public List<Integer> getAlliedMonsters() {
        String query = AlliedMonstersQueries.getSelectAllAlliedMonstersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Integer> alliedMonsters = MariaDBResultReader.getAlliedMonsterIDsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return alliedMonsters;
    }
}
