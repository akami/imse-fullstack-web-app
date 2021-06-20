package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.mongoDB.MongoDBExecuter;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import com.mongodb.Mongo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void createMongoPlayer(Player player)
    {
        Document playerDocument = PlayerDocumentCreator.createPlayerDocument(player, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>());

        MongoDBConnectionHandler.setupConnection();

        MongoDBExecuter.insertDocument(MongoDBConnectionHandler.getDb(), playerDocument, PlayerDocumentCreator.PLAYER_COLLECTION_NAME);

        MongoDBConnectionHandler.closeConnection();
    }

    public List<Player> getPlayers() {
        String query = PlayerQueries.getSelectAllPlayersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Player> players = MariaDBResultReader.getPlayersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return players;
    }

    public List<MongoPlayer> getMongoPlayers() {
        MongoDBConnectionHandler.setupConnection();
        List<MongoPlayer> players = MongoPlayerQueries.getMongoPlayers();
        MongoDBConnectionHandler.closeConnection();
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

    public Player getPlayerByUsername(String username) {
        List<Player> players = getPlayers();

        Player player = players.stream()
                .filter(p -> p.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        return player;
    }

    public MongoPlayer getMongoPlayerByUsername(String username) {
        List<MongoPlayer> players = getMongoPlayers();

        MongoPlayer player = players.stream()
                .filter(p -> p.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        return player;
    }

    /*
    public Integer getGoldAmountOfPlayer(Integer playerId)
    {
        String query = PlayerQueries.getGoldAmountFromPlayer(playerId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        Integer goldAMount = MariaDBResultReader.getIntegerFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return goldAMount;
    }

     */
}
