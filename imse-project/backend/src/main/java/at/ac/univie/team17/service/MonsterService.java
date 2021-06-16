package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.MonsterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MonsterService {
    public void saveMonster(Monster monster) {
        String query = MonsterQueries.getInsertMonsterQuery(monster);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<Monster> getMonsters() {
        String query = MonsterQueries.getSelectAllMonstersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Monster> monsters = MariaDBResultReader.getMonstersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return monsters;
    }
}
