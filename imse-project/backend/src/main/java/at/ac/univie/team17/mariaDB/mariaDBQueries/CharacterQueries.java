package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Character;

public class CharacterQueries
{
    public static String getInsertCharacterQuery(Character character)
    {
        return "INSERT INTO player_character (character_id, attack, lifepoints, character_name, player_id, character_class_id) VALUES ('" +
                character.getCharacterId() + "', '" + character.getAttack() + "', '" + character.getLifepointAmount() +
                "', '" + character.getCharacterName() + "', '" + character.getPlayerId() + "', '" + character.getCharacterClassId()+ "');";
    }

    public static String getSelectAllCharactersQuery()
    {
        return "SELECT * FROM character;";
    }

    public static String getSelectCharacterFromIdQuery(int id)
    {
        return "SELECT * FROM player_character WHERE character_id = " + id + ";";
    }

    public static String getCreateCharacterTableQuery()
    {
        return "CREATE TABLE player_character (character_id INT, attack INT, lifepoints INT, character_name CHAR(25), player_id INT," +
                " character_class_id INT, PRIMARY KEY (character_id), CONSTRAINT player_character_fk_player FOREIGN KEY (player_id) " +
                "REFERENCES player(player_id) ON DELETE CASCADE ON UPDATE RESTRICT, CONSTRAINT player_character_fk_character_class FOREIGN " +
                "KEY (character_class_id) REFERENCES character_class(character_class_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropCharacterTableQuery()
    {
        return "DROP TABLE player_character;";
    }
}
