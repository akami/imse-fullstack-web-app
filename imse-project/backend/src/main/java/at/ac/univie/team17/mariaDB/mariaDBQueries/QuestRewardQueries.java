package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;

public class QuestRewardQueries
{
    public static String getInsertQuestRewardQuery(QuestReward questReward)
    {
        return "INSERT INTO quest_reward(quest_reward_id, gold_amount, experience_amount) VALUES ('" +
                questReward.getQuestRewardId() + "', '" + questReward.getGoldAmount() + "', '" + questReward.getExperienceAmount() + "');";
    }

    public static String getSelectAllQuestRewardsQuery()
    {
        return "SELECT * FROM quest_reward;";
    }

    public static String getSelectQuestRewardFromIdQuery(int id)
    {
        return "SELECT * FROM quest_reward WHERE quest_reward_id = " + id + ";";
    }

    public static String getCreateQuestRewardTableQuery()
    {
        return "CREATE TABLE quest_reward(quest_reward_id INT, gold_amount INT, experience_amount INT, PRIMARY KEY (quest_reward_id);";
    }
}
