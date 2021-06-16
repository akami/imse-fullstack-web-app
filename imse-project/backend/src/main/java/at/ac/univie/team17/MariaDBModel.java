package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBDataInitializer;
import at.ac.univie.team17.mariaDB.MariaDBTableDropper;
import at.ac.univie.team17.mariaDB.MariaDBTableInitializer;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class MariaDBModel
{

    public ResultSet query(String query) {
        setupConnection();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection();

        return resultSet;
    }

    public void initialize() {
        MariaDBConnectionHandler.setupConnection();
        MariaDBTableDropper.dropMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBTableInitializer.initializeMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBDataInitializer.initializeMariaDBData(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }

    public void clear() {
        MariaDBConnectionHandler.setupConnection();
        MariaDBTableDropper.dropMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }
}
