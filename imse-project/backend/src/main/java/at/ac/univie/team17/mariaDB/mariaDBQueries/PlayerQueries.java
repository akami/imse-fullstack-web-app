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
                "(" + // start bought pets
                "(SELECT SUM(gold_price) AS bought_pets_gold FROM " +
                "((SELECT pet_id FROM player_pet WHERE player_id = " + playerId + ") AS players_pets" +
                "JOIN pet ON pet.pet_id = players_pets.pet_id)) AS players_pets_gold " +
                "JOIN " + // end bought pets; start gold offers
                "(SELECT SUM(gold_amount) AS gold_offer_gold FROM " +
                "gold_offer WHERE player_id = " + playerId + ") AS players_gold_offers_gold " +
                "JOIN " + // end gold offers;
                "" +
                "" +
                "" +
                "" +
                "" +
                ") AS gold_table;";
    }
}
