package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBModel;
import at.ac.univie.team17.mariaDB.mariaDBQueries.PlayerQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerService {
    @Autowired
    private MariaDBModel mariaDBModel;

    public String getPlayerId(String email, String username) {
        String query = PlayerQueries.getSelectPlayerIdFromUsernameAndEmailQuery(email, username);
        ResultSet result = mariaDBModel.query(query);

        try {
            return result.getString(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
