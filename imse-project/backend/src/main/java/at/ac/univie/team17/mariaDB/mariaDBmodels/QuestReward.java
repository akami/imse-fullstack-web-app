package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class QuestReward
{
    private int questRewardId;
    private int goldAmount;
    private int experienceAmount;

    public QuestReward(int questRewardId, int goldAmount, int experienceAmount)
    {
        this.questRewardId = questRewardId;
        this.goldAmount = goldAmount;
        this.experienceAmount = experienceAmount;
    }

    public int getQuestRewardId()
    {
        return questRewardId;
    }

    public int getGoldAmount()
    {
        return goldAmount;
    }

    public int getExperienceAmount()
    {
        return experienceAmount;
    }
}
