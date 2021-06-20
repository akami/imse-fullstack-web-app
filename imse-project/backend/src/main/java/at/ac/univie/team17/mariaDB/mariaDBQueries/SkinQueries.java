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

    public static String getSelectSkinFromSkinIdQuery(int id)
    {
        return "SELECT * FROM skin WHERE skin_id = " + id + ";";
    }

    public static String getCreateSkinTableQuery()
    {
        return "CREATE TABLE skin(skin_id INT, character_class_id INT, skin_name CHAR(30), gold_price INT, " +
                "PRIMARY KEY (skin_id, character_class_id), CONSTRAINT skin_fk_character_class FOREIGN KEY (character_class_id) REFERENCES " +
                "character_class(character_class_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropSkinTableQuery()
    {
        return "DROP TABLE skin;";
    }

    public static String getSelectSkinsFromClassIdQuery(int classId)
    {
        return "SELECT * FROM skin WHERE character_class_id = " + classId + ";";
    }

    public static String getSkinReportQuery()
    {
        return "SELECT skin.character_class_id, skin.skin_id, skin_name, COUNT(*) AS bought_amount FROM " +
                "((SELECT player_id FROM player WHERE age < 31 AND age > 17) AS audience_players " +
                "JOIN player_character ON player_character.player_id = audience_players.player_id " +
                "JOIN character_skin ON player_character.character_id = character_skin.character_id " +
                "JOIN skin ON character_skin.skin_id = skin.skin_id " +
                ") " +
                "GROUP BY skin.character_class_id, skin.skin_id " +
                "ORDER BY bought_amount;";
    }
}
