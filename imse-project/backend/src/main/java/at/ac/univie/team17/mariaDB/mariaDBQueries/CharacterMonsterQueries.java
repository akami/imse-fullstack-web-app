package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;

public class CharacterMonsterQueries
{
    public static String getInsertCharacterMonsterQuery(CharacterMonster characterMonster)
    {
        return "INSERT INTO character_monster (character_id, monster_id, slay_amount) VALUES ('" + characterMonster.getCharacterId() + "', '" +
                characterMonster.getMonsterId() + "', '" + characterMonster.getSlayAmount() + "');";
    }
    public static String getUpdateCharacterMonsterQuery(int characterId, int monsterId)
    {
        return "UPDATE character_monster SET slay_amount = slay_amount + 1 WHERE character_id = " + characterId +
                " AND monster_id = " + monsterId + ";";
    }

    public static String getSelectAllCharacterMonstersQuery()
    {
        return "SELECT * FROM character_monster;";
    }

    public static String getSelectCharacterMonsterFromIdQuery(int characterId, int monsterId)
    {
        return "SELECT * FROM character_monster WHERE character_id = " + characterId + " AND monster_id = " + monsterId + ";";
    }

    public static String getCreateCharacterMonsterTableQuery()
    {
        return "CREATE TABLE character_monster (character_id INT, monster_id INT, slay_amount INT, PRIMARY KEY (character_id, monster_id), " +
                "CONSTRAINT character_monster_fk_character FOREIGN KEY (character_id) REFERENCES player_character (character_id) " +
                "ON DELETE CASCADE ON UPDATE RESTRICT, CONSTRAINT character_monster_fk_monster FOREIGN KEY (monster_id) REFERENCES " +
                "monster(monster_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropCharacterMonsterTableQuery()
    {
        return "DROP TABLE character_monster;";
    }

    /*


    public static String getSelectSlayedMonstersFromCharacterIdQuery(int characterId)
    {
        return "SELECT result_table.monster_id, result_table.slay_amount, result_table.gold_amount, " +
                "result_table.experience_amount FROM" +
                "((SELECT slayed_monsters.monster_id, slayed_monsters.slay_amount, monster.monster_loot_id FROM " +
                "character_monster WHERE character_id = " + characterId + ") AS slayed_monsters" +
                "JOIN monster ON slayed_monsters.monster_id = monster.monster_id) AS slayed_monsters_monster " +
                "JOIN monster_loot ON slayed_monsters_monster.monster_loot_id = monster_loot.monster_loot_id AS result_table;";
    } */

    public static String getSelectSlayedMonstersFromCharacterIdQuery(int characterId)
    {
        return "SELECT result_table.monster_id, result_table.slay_amount, result_table.gold_amount, " +
                "result_table.experience_amount FROM " +
                "(SELECT monster.monster_id, character_monster.slay_amount, monster_loot.gold_amount, monster_loot.experience_amount " +
                "FROM character_monster JOIN monster ON character_monster.monster_id = monster.monster_id " +
                "JOIN monster_loot ON monster.monster_loot_id = monster_loot.monster_loot_id " +
                "WHERE character_monster.character_id = " + characterId + ") AS result_table;";
    }
}
