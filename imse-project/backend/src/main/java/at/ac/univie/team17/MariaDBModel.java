package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBDataInitializer;
import at.ac.univie.team17.mariaDB.MariaDBTableDropper;
import at.ac.univie.team17.mariaDB.MariaDBTableInitializer;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class MariaDBModel
{
    private Connection connection = null;
    private Statement statement = null;

    public void initialize() {
        setupConnection();
        MariaDBTableInitializer.initializeMariaDBTables(statement);
        MariaDBDataInitializer.initializeMariaDBData(statement);
        closeConnection();
    }

    public void clear() {
        setupConnection();
        MariaDBTableDropper.dropMariaDBTables(statement);
        closeConnection();
    }

    private void setupConnection()
    {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mysql?user=root&password=mariadb");
            statement = connection.createStatement();
        } catch (SQLException throwables)
        {
            System.out.println("Failed");
            throwables.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void closeConnection()
    {
        try
        {
            statement.close();
            connection.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
