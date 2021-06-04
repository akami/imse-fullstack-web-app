package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;

public class CharacterSkinQueries
{
    public static String getInsertCharacterSkinQuery(CharacterSkin characterSkin)
    {
        return "INSERT INTO character_skin (character_id, skin_id) VALUES ('" + characterSkin.getCharacterId() + "', '" +
                characterSkin.getSkinId() + "');";
    }

    public static String getSelectAllCharacterSkinsQuery()
    {
        return "SELECT * FROM character_skin;";
    }

    public static String getSelectCharacterSkinFromIdQuery(int characterId, int skinId)
    {
        return "SELECT * FROM character_skin WHERE character_id = " + characterId + " AND skin_id = " + skinId + ";";
    }

    public static String getCreateCharacterSkinTableQuery()
    {
        return "CREATE TABLE character_skin (character_id INT, skin_id INT, PRIMARY KEY (character_id, skin_id), " +
                "CONSTRAINT 'fk_character' FOREIGN KEY (character_id) REFERENCES character (character_id) ON DELETE CASCADE ON UPDATE RESTRICT" +
                ", CONSTRAINT 'fk_skin' FOREIGN KEY (skin_id) REFERENCES skin(skin_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }
}
