package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterMonsterQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterClassQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoMonsterQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterSlayedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoAlliedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.SlayedMonsters;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMonsterService {

    public List<CharacterMonster> getCharacterMonsters() {
        String query = CharacterMonsterQueries.getSelectAllCharacterMonstersQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterMonster> characterMonsters = MariaDBResultReader.getCharacterMonstersFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characterMonsters;
    }

    public List<CharacterSlayedMonsters> getCharacterSlayedMonsters()
    {
        List<CharacterSlayedMonsters> characterSlayedMonsters = MongoCharacterQueries.getCharacterSlayedMonsters();
        return characterSlayedMonsters;
    }

    public void addSlayedMonsterToGameCharacter(Integer characterId, Integer monsterId)
    {
        String query = CharacterMonsterQueries.getSelectCharacterMonsterFromIdQuery(characterId, monsterId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterMonster> characterMonsters = MariaDBResultReader.getCharacterMonstersFromResultSet(result);

        if (characterMonsters.isEmpty())
        {
            query = CharacterMonsterQueries.getInsertCharacterMonsterQuery(new CharacterMonster(characterId, monsterId, 1));
            MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        } else
        {
            query = CharacterMonsterQueries.getUpdateCharacterMonsterQuery(characterId, monsterId);
            MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        }
        MariaDBConnectionHandler.closeConnection();
    }

    public void addSlayedMonsterToMongoCharacter(Integer characterId, MongoMonster mongoMonster)
    {
        List<SlayedMonsters> characterSlayedMonsters = MongoCharacterQueries.getCharacterSlayedMonstersFromCharacter(characterId);

        boolean exists = false;
        for (SlayedMonsters slayedMonsters : characterSlayedMonsters)
        {
            if (slayedMonsters.getMonsterId() == mongoMonster.getMonsterId())
            {
                exists = true;
                slayedMonsters.increaseSlayAmount();
                MongoCharacterQueries.updateSlayedMonster(characterId, slayedMonsters);
            }
        }
        if (!exists)
        {
            MongoCharacterQueries.addSlayedMonster(characterId, mongoMonster);
        }
    }
}
