package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBConnectionHandler;
import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.CharacterSkinQueries;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSkinService {
    public List<Skin> getCharacterSkins() {
        String query = CharacterSkinQueries.getSelectAllCharacterSkinsQuery();

        MariaDBConnectionHandler.setupConnection();

        ResultSet result = MariaDBQueryExecuter.executeReturnQuery(MariaDBConnectionHandler.getStatement(), query);
        ArrayList<Skin> skins = MariaDBResultReader.getSkinsFromResultSet(result);

        MariaDBConnectionHandler.closeConnection();

        return skins;
    }
}
