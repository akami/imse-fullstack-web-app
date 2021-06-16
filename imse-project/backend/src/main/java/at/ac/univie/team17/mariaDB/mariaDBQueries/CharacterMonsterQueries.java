package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterMonster;

public class CharacterMonsterQueries
{
    public static String getInsertCharacterMonsterQuery(CharacterMonster characterMonster)
    {
        return "INSERT INTO character_monster (character_id, monster_id, slay_amount) VALUES ('" + characterMonster.getCharacterId() + "', '" +
                characterMonster.getMonsterId() + "', '" + characterMonster.getSlayAmount() + "');";
    }

    public static String getSelectAllCharacterMonstersQuery()
    {
        return "SELECT * FROM character;";
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

}
