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

    public static String getSelectCharacterSkinsFromCharacterIdQuery(int characterId)
    {
        return "SELECT skin.* FROM " +
                "(SELECT * FROM character_skin WHERE character_id = " + characterId + ") AS bought_skins " +
                "JOIN skin ON bought_skins.skin_id = skin.skin_id;";
    }

    public static String getCreateCharacterSkinTableQuery()
    {
        return "CREATE TABLE character_skin (character_id INT, skin_id INT, PRIMARY KEY (character_id, skin_id), " +
                "CONSTRAINT character_skin_fk_character FOREIGN KEY (character_id) REFERENCES player_character (character_id) ON DELETE CASCADE ON UPDATE RESTRICT" +
                ", CONSTRAINT character_skin_fk_skin FOREIGN KEY (skin_id) REFERENCES skin(skin_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropCharacterSkinClassTableQuery()
    {
        return "DROP TABLE character_skin;";
    }

    public static String getSelectAvailableCharacterSkinsToBuyQuery(Integer characterId)
    {
        return  "SELECT * FROM " +
                "(SELECT skin_id AS skin_id, skin.character_class_id AS character_class_id, skin_name, gold_price FROM " +
                "((SELECT character_class_id FROM player_character WHERE character_id = " + characterId + ") AS characters_class " +
                "JOIN skin ON characters_class.character_class_id = skin.character_class_id)) AS all_class_skins " +
                "EXCEPT " +
                "SELECT * FROM " +
                "(SELECT skin.skin_id AS skin_id, character_class_id AS character_class_id, skin_name, gold_price FROM " +
                "((SELECT skin_id FROM character_skin WHERE character_id = " + characterId + ") AS character_bought_skin_ids " +
                "JOIN skin ON character_bought_skin_ids.skin_id = skin.skin_id)) AS already_bought_character_skins;";
    }
}
