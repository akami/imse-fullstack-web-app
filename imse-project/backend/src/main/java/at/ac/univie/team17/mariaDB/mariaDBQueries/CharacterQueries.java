package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;

public class CharacterQueries
{
    public static String getInsertCharacterQuery(GameCharacter gameCharacter)
    {
        return "INSERT INTO player_character (character_id, attack, lifepoints, character_name, player_id, character_class_id) VALUES ('" +
                gameCharacter.getCharacterId() + "', '" + gameCharacter.getAttack() + "', '" + gameCharacter.getLifepointAmount() +
                "', '" + gameCharacter.getCharacterName() + "', '" + gameCharacter.getPlayerId() + "', '" + gameCharacter.getCharacterClassId()+ "');";
    }

    public static String getSelectAllCharactersQuery()
    {
        return "SELECT * FROM player_character;";
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

    public static String getSelectCharacterFromPlayerIdQuery(int playerId)
    {
        return "SELECT * FROM player_character WHERE player_id = " + playerId + ";";
    }

    public static String getSelectCharacterClassFromCharacterId(int characterId)
    {
        return "SELECT character_class.* FROM " +
                "(SELECT character_class_id FROM player_character WHERE character_id = " + characterId + ") AS characters_class " +
                "JOIN character_class ON characters_class.character_class_id = character_class.character_class_id;";
    }
}
