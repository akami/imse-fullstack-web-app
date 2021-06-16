package at.ac.univie.team17.mariaDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBQueryExecuter
{
    private static String mQuery = "";
    public static void executeNoReturnQuery(Statement statement, String query)
    {
        try
        {
            mQuery = query;
            statement.executeQuery(query);
        } catch (SQLException throwables)
        {
            System.out.println(mQuery);
            throwables.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ResultSet executeReturnQuery(Statement statement, String query)
    {
        try
        {
            mQuery = query;
            return statement.executeQuery(query);
        } catch (SQLException throwables)
        {
            System.out.println(mQuery);
            throwables.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
