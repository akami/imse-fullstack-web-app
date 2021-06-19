package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterSkinQueries;
import at.ac.univie.team17.mariaDB.mariaDBQueries.SkinQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterClassQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.CharacterClassMongoSkins;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class SkinService {
    public List<Skin> getAllSkins() {
        String query = SkinQueries.getSelectAllSkinsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Skin> skins = MariaDBResultReader.getSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return skins;
    }

    public List<Skin> getSkinsFromClassId(int classId) {
        String query = SkinQueries.getSelectSkinsFromClassIdQuery(classId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Skin> skins = MariaDBResultReader.getSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return skins;
    }

    public List<CharacterClassMongoSkins> getAllMongoSkins()
    {
        List<CharacterClassMongoSkins> mongoSkins = MongoCharacterClassQueries.getAllMongoSkins();
        return mongoSkins;
    }

    public List<MongoSkin> getMongoSkinsFromClassId(Integer classId)
    {
        List<MongoSkin> mongoSkins = MongoCharacterClassQueries.getMongoSkinsFromClassId(classId);
        return mongoSkins;
    }

    public List<Skin> getAvailableSkinsFromCharacterId(Integer characterId)
    {
        String query = CharacterSkinQueries.getSelectAvailableCharacterSkinsToBuyQuery(characterId);

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Skin> skins = MariaDBResultReader.getSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return skins;
    }

    public List<MongoSkin> getAvailableMongoSkinsFromCharacterId(Integer characterId)
    {
        List<MongoSkin> mongoSkins = MongoCharacterQueries.getAvailableMongoSkinsFromCharacterId(characterId);
        return mongoSkins;
    }

    public void addSkinToCharacter(Integer characterId, Integer skinId)
    {
        String query = CharacterSkinQueries.getInsertCharacterSkinQuery(new CharacterSkin(characterId, skinId));

        MariaDBConnectionHandler.setupConnection();
        MariaDBQueryExecuter.executeNoReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        MariaDBConnectionHandler.closeConnection();
    }

    public void addMongoSkinToMongoCharacter(Integer characterId, MongoSkin mongoSkin)
    {
        MongoCharacterQueries.addBoughtSkinToCharacter(characterId, mongoSkin);
    }
}
