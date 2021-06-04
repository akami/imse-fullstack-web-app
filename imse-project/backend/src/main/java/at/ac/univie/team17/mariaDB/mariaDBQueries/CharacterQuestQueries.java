package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterQuest;

public class CharacterQuestQueries
{
    public static String getInsertCharacterQuestQuery(CharacterQuest characterQuest)
    {
        return "INSERT INTO character (character_id, quest_id) VALUES ('" + characterQuest.getCharacterId() + "', '" +
                characterQuest.getQuestId() + "');";
    }

    public static String getSelectAllCharacterQuestsQuery()
    {
        return "SELECT * FROM character;";
    }

    public static String getSelectCharacterQuestFromIdQuery(int characterId, int questId)
    {
        return "SELECT * FROM character WHERE character_id = " + characterId + " AND quest_id = " + questId + ";";
    }

    public static String getCreateCharacterQuestTableQuery()
    {
        return "CREATE TABLE character (character_id INT, quest_id INT, PRIMARY KEY (character_id, quest_id));";
    }
}
