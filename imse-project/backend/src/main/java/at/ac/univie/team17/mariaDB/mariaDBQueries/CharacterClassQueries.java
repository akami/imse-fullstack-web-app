package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;

public class CharacterClassQueries
{
    public static String getInsertCharacterClassQuery(CharacterClass characterClass)
    {
        return "INSERT INTO character_class (character_class_id, bonus_attack, bonus_lifepoints, character_class_name) VALUES ('" +
                characterClass.getClassId() + "', '" + characterClass.getBonusAttack() + "', '" +
                characterClass.getBonusLifepoints() + "', '" + characterClass.getClassName() + "');";
    }

    public static String getSelectAllCharacterClassesQuery()
    {
        return "SELECT * FROM character_class;";
    }

    public static String getSelectCharacterClassFromIdQuery(int id)
    {
        return "SELECT * FROM character_class WHERE character_class_id = " + id + ";";
    }

    public static String getCreateCharacterClassTableQuery()
    {
        return "CREATE TABLE character_class (character_class_id INT, bonus_attack INT, bonus_lifepoints INT, " +
                "character_class_name CHAR(25), PRIMARY KEY (character_class_id));";
    }

    public static String getDropCharacterClassTableQuery()
    {
        return "DROP TABLE character_class;";
    }

    public static String getClassReportQuery()
    {
        return "SELECT class.character_class_id, character_class_name, COUNT(*) AS chosen_amount FROM " +
                "((SELECT player_id FROM player WHERE age < 31 AND age > 17) AS audience_players " +
                "JOIN player_character ON player_character.player_id = audience_players.player_id " +
                "JOIN character_class ON player_character.character_class_id = character_class.character_class_id " +
                ") " +
                "GROUP BY class.character_class_id " +
                "ORDER BY chosen_amount;";
    }
}
