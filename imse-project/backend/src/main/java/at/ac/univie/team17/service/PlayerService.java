package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerService {

    public void createPlayer(Player player) {
        String query = PlayerQueries.getInsertPlayersQuery(player);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<Player> getPlayers() {
        String query = PlayerQueries.getSelectAllPlayersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Player> players = MariaDBResultReader.getPlayersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return players;
    }

    public int getPlayerId(String email, String username) {
        List<Player> players = getPlayers();

        Player player = players.stream()
                .filter(p -> p.getUsername().equals(username) && p.getEmailAddress().equals(email))
                .findFirst()
                .orElse(null);

        return player != null ? player.getPlayerId() : -1;
    }
}
