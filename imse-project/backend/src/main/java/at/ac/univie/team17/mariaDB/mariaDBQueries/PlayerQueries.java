package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;

public class PlayerQueries
{
    public static String getInsertPlayersQuery(Player player)
    {
        return "INSERT INTO player(player_id, user_name, email_address) VALUES ('" + player.getPlayerId() + "', '" +
                player.getUsername() + "', '" + player.getEmailAddress() + "');";
    }

    public static String getSelectAllPlayersQuery()
    {
        return "SELECT * FROM player;";
    }

    public static String getSelectPlayerFromIdQuery(int id)
    {
        return "SELECT * FROM player WHERE player_id = " + id + ";";
    }

    public static String getCreatePlayerTableQuery()
    {
        return "CREATE TABLE player(player_id INT, user_name CHAR(30), email_address CHAR(40), PRIMARY KEY (player_id));";
    }

    public static String getDropPlayerTableQuery()
    {
        return "DROP TABLE player;";
    }
}
