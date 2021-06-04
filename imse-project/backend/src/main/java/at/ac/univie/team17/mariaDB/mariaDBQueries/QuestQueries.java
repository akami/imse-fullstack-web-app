package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;

public class QuestQueries
{
    public static String getInsertQuestQuery(Quest quest)
    {
        return "INSERT INTO quest(quest_id, quest_name, client_name, quest_reward_id)" +
                " VALUES ('" + quest.getQuestId() + "', '" + quest.getQuestName() + "', '" + quest.getClientName() +
                "', '" + quest.getQuestRewardId() + "');";
    }

    public static String getSelectAllQuestsQuery()
    {
        return "SELECT * FROM quest;";
    }

    public static String getSelectQuestFromIdQuery(int id)
    {
        return "SELECT * FROM quest WHERE quest_id = " + id + ";";
    }

    public static String getCreateQuestTableQuery()
    {
        return "CREATE TABLE quest(quest_id INT, quest_name CHAR(30), client_name CHAR(30), quest_reward_id INT, " +
                "PRIMARY KEY (quest_id), CONSTRAINT 'fk_quest_reward' FOREIGN KEY (quest_reward_id) REFERENCES " +
                "quest_reward(quest_reward_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }
}
