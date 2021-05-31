package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodelDataGenerators.PlayerDataGenerator;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MariaDBDataInitializer
{
    public static void initializeMariaDBData(Statement statement)
    {
        ArrayList<Player> players = PlayerDataGenerator.generatePlayerData();

        insertPlayersInMariaDB(statement, players);
    }

    private static void insertPlayersInMariaDB(Statement statement, ArrayList<Player> players)
    {
        String insertQuery;
        for (Player player : players)
        {
            insertQuery = PlayerQueries.getInsertPlayersQuery(player);
            try
            {
                statement.executeQuery(insertQuery);
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }
}
