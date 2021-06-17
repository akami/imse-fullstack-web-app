package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.MonsterLootQueries;
import at.ac.univie.team17.mariaDB.mariaDBQueries.MonsterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MonsterLootService {
    public List<MonsterLoot> getMonsterLoots() {
        String query = MonsterLootQueries.getSelectAllMonsterLootsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<MonsterLoot> monsterLoots = MariaDBResultReader.getMonsterLootsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return monsterLoots;
    }
}
