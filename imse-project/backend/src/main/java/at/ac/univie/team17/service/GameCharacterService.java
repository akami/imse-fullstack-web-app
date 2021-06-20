package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.MongoDBExecuter;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.CharacterDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.PlayerAgeDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterClassQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.PlayerAge;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameCharacterService {

    public void createGameCharacter(GameCharacter character) {
        String query = CharacterQueries.getInsertCharacterQuery(character);

        MariaDBConnectionHandler.setupConnection();

        MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);

        MariaDBConnectionHandler.closeConnection();
    }

    public List<GameCharacter> getGameCharacters() {
        String query = CharacterQueries.getSelectAllCharactersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<GameCharacter> characters = MariaDBResultReader.getGameCharactersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characters;
    }

    public List<MongoCharacter> getMongoCharacters()
    {
        MongoDBConnectionHandler.setupConnection();
        List<MongoCharacter> characters = MongoCharacterQueries.getMongoCharacters();
        MongoDBConnectionHandler.closeConnection();
        return characters;
    }

    public List<GameCharacter> getGameCharactersById(int playerId) {
        String query = CharacterQueries.getSelectCharactersFromPlayerIdQuery(playerId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<GameCharacter> characters = MariaDBResultReader.getGameCharactersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characters;
    }

    public List<MongoCharacter> getMongoCharactersByPlayerId(Integer playerId)
    {
        List<MongoCharacter> mongoCharacters = new ArrayList<>();
        List<Integer> mongoCharacterIds = MongoPlayerQueries.getMongoCharacterIdsFromPlayer(playerId);
        for (Integer id : mongoCharacterIds)
        {
            mongoCharacters.add(MongoCharacterQueries.getMongoCharacterFromId(id));
        }
        return mongoCharacters;
    }

    public void createMongoCharacter(GameCharacter gameCharacter, int age)
    {
        Document playerAgeDocument = PlayerAgeDocumentCreator.getPlayerAgeDocument(new PlayerAge(gameCharacter.getPlayerId(), age));
        Document characterClassDocument = MongoCharacterClassQueries.getCharacterClassFromId(gameCharacter.getCharacterClassId());
        Document mongoCharacter = CharacterDocumentCreator.createCharacterDocument(
                CharacterDocumentCreator.getMongoCharacterFromCharacter(gameCharacter), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), playerAgeDocument, characterClassDocument);

        MongoDBConnectionHandler.setupConnection();
        // insert into characters
        MongoDBExecuter.insertDocument(MongoDBConnectionHandler.getDb(), mongoCharacter, CharacterDocumentCreator.CHARACTER_COLLECTION_NAME);
        // insert into player's characters
        MongoPlayerQueries.insertMongoCharacterInPlayer(mongoCharacter, gameCharacter.getPlayerId());
        MongoDBConnectionHandler.closeConnection();
    }
}
