package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBDataInitializer;
import at.ac.univie.team17.mariaDB.MariaDBTableDropper;
import at.ac.univie.team17.mariaDB.MariaDBTableInitializer;

public class MariaDBModel
{
    public static void initialize() {
        clear();

        MariaDBConnectionHandler.setupConnection();
        MariaDBDataInitializer.initializeMariaDBData(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }

    public static void clear() {
        MariaDBConnectionHandler.setupConnection();
        MariaDBTableDropper.dropMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBTableInitializer.initializeMariaDBTables(MariaDBConnectionHandler.getStatement());
        MariaDBConnectionHandler.closeConnection();
    }
}
