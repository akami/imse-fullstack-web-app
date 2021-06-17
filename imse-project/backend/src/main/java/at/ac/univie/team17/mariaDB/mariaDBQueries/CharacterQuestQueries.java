package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterQuest;

public class CharacterQuestQueries
{
    public static String getInsertCharacterQuestQuery(CharacterQuest characterQuest)
    {
        return "INSERT INTO character_quest (character_id, quest_id) VALUES ('" + characterQuest.getCharacterId() + "', '" +
                characterQuest.getQuestId() + "');";
    }

    public static String getSelectAllCharacterQuestsQuery()
    {
        return "SELECT * FROM character;";
    }

    public static String getSelectCharacterQuestFromIdQuery(int characterId, int questId)
    {
        return "SELECT * FROM character_quest WHERE character_id = " + characterId + " AND quest_id = " + questId + ";";
    }

    public static String getCreateCharacterQuestTableQuery()
    {
        return "CREATE TABLE character_quest (character_id INT, quest_id INT, PRIMARY KEY (character_id, quest_id), " +
                "CONSTRAINT character_quest_fk_character FOREIGN KEY (character_id) REFERENCES player_character (character_id) " +
                "ON DELETE CASCADE ON UPDATE RESTRICT, CONSTRAINT character_quest_fk_quest FOREIGN KEY (quest_id) REFERENCES " +
                "quest(quest_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropCharacterQuestClassTableQuery()
    {
        return "DROP TABLE character_quest;";
    }

    public static String getSelectCompletedQuestsFromCharacterIdQuery(int characterId)
    {
        return "SELECT quest.* FROM " +
                "(SELECT * FROM character_quest WHERE character_id = " + characterId + ") AS completed_quests " +
                "JOIN quest ON completed_quests.quest_id = quest.quest_id;";
    }
}
