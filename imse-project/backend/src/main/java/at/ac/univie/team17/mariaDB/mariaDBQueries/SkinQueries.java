package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;

public class SkinQueries
{
    public static String getInsertSkinQuery(Skin skin)
    {
        return "INSERT INTO skin(skin_id, character_class_id, skin_name, gold_price) VALUES ('" + skin.getSkinId() + "', '" +
                skin.getClassId() + "', '" + skin.getSkinName() + "', '" + skin.getGoldPrice() + "');";
    }

    public static String getSelectAllSkinsQuery()
    {
        return "SELECT * FROM skin;";
    }

    public static String getSelectSkinFromIdQuery(int id)
    {
        return "SELECT * FROM skin WHERE skin_id = " + id + ";";
    }

    public static String getCreateSkinTableQuery()
    {
        return "CREATE TABLE skin(skin_id INT, character_class_id INT, skin_name CHAR(30), gold_price INT, " +
                "PRIMARY KEY (skin_id, character_class_id), CONSTRAINT 'fk_character_class' FOREIGN KEY (character_class_id) REFERENCES " +
                "character_class(character_class_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }
}
