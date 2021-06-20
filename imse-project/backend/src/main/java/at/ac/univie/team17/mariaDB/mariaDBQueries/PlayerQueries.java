package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;

public class PlayerQueries
{
    public static String getInsertPlayersQuery(Player player)
    {
        return "INSERT INTO player(user_name, age, email_address) VALUES ('" +
                player.getUsername() + "', '" + player.getAge() + "', '" + player.getEmailAddress() + "');";
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
        return "CREATE TABLE player(player_id INT NOT NULL AUTO_INCREMENT, user_name CHAR(30), age INT, email_address CHAR(40), PRIMARY KEY (player_id));";
    }

    public static String getDropPlayerTableQuery()
    {
        return "DROP TABLE player;";
    }

    public static String getGoldAmountFromPlayer(Integer playerId) // TODO
    {
        return "SELECT 200 + monster_loot_gold + quest_reward_gold + gold_offer_gold - bought_pets_gold - bought_skins_gold " +
                "AS player_gold_amount FROM " +
                "(SELECT " +
                ") AS gold_table;";
    }
}
