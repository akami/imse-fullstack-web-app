package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBDataInitializer;
import at.ac.univie.team17.mariaDB.MariaDBTableDropper;
import at.ac.univie.team17.mariaDB.MariaDBTableInitializer;
import org.springframework.stereotype.Component;

import java.sql.*;

public class MariaDBModel
{
    public static void initialize() {
        MariaDBConnectionHandler.setupConnection();
        MariaDBTableDropper.dropMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBTableInitializer.initializeMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBDataInitializer.initializeMariaDBData(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }

    public static void clear() {
        MariaDBConnectionHandler.setupConnection();
        MariaDBTableDropper.dropMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }
}
