package at.ac.univie.team17.mariaDB;

import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBQueryExecuter
{
    public static void executeQuery(Statement statement, String query)
    {
        try
        {
            statement.executeQuery(query);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
