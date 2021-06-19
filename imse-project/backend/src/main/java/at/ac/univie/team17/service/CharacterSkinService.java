package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterSkinQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterSlayedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSkinService {
    public List<CharacterSkin> getCharacterSkins() {
        String query = CharacterSkinQueries.getSelectAllCharacterSkinsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterSkin> characterSkins = MariaDBResultReader.getCharacterSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characterSkins;
    }

    public List<CharacterSkin> getCharacterSkinsForCharacterId(int characterId) {
        String query = CharacterSkinQueries.getSelectCharacterSkinsFromCharacterIdQuery(characterId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<CharacterSkin> characterSkins = MariaDBResultReader.getCharacterSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return characterSkins;
    }

    public List<MongoCharacterSkin> getMongoCharacterSkins()
    {
        List<MongoCharacterSkin> characterSkins = MongoCharacterQueries.getCharacterSkins();
        return characterSkins;
    }

    public List<MongoCharacterSkin> getMongoCharacterSkinsForCharacterId(Integer characterId)
    {
        List<MongoCharacterSkin> characterSkins = MongoCharacterQueries.getCharacterSkinsFromCharacterId(characterId);
        return characterSkins;
    }
}
