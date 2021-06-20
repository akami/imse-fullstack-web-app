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

    public static String getGoldAmountFromPlayer(Integer playerId)
    {
        return "SELECT 200 + quest_reward_gold + gold_offer_gold + monster_loot_gold - bought_skins_gold - bought_pets_gold AS total_gold " +
                " FROM " +
                "(" + // start bought pets
                "(SELECT COALESCE(SUM(gold_price),0) AS bought_pets_gold FROM " +
                "((SELECT pet_id FROM player_pet WHERE player_id = " + playerId + ") AS players_pets " +
                "JOIN pet ON pet.pet_id = players_pets.pet_id)) AS players_pets_gold " +
                "JOIN " + // end bought pets; start gold offers
                "(SELECT COALESCE(SUM(gold_amount),0) AS gold_offer_gold FROM " +
                "gold_offer WHERE player_id = " + playerId + ") AS players_gold_offers_gold " +
                "JOIN " + // end gold offers; start bought skins
                "(SELECT COALESCE(SUM(gold_price),0) AS bought_skins_gold FROM " +
                "((SELECT character_id FROM player_character WHERE player_id = " + playerId + ") AS players_chars " +
                "JOIN character_skin ON character_skin.character_id = players_chars.character_id " +
                "JOIN skin ON skin.skin_id = character_skin.skin_id)) AS players_skin_gold " +
                "JOIN " + // end bought skins; start quest reward
                "(SELECT COALESCE(SUM(gold_amount),0) AS quest_reward_gold FROM " +
                "((SELECT character_id FROM player_character WHERE player_id = " + playerId + ") AS players_chars2 " +
                "JOIN character_quest ON character_quest.character_id = players_chars2.character_id " +
                "JOIN quest ON character_quest.quest_id = quest.quest_id " +
                "JOIN quest_reward ON quest.quest_reward_id = quest_reward.quest_reward_id)) AS players_quest_gold " +
                "JOIN " + // end quest reward; start monster loot
                "(SELECT COALESCE(SUM(gold_amount),0) AS monster_loot_gold FROM " +
                "((SELECT character_id FROM player_character WHERE player_id = " + playerId + ") AS players_chars3 " +
                "JOIN character_monster ON players_chars3.character_id = character_monster.character_id " +
                "JOIN monster ON monster.monster_id = character_monster.monster_id " +
                "JOIN monster_loot ON monster.monster_loot_id = monster_loot.monster_loot_id)) AS players_monster_gold " + // end monster loot
                ");";
    }
}
