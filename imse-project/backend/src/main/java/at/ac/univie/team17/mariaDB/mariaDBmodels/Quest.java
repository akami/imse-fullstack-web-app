package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Quest
{
    private int questId;
    private String questName;
    private String clientName;

    public Quest(int questId, String questName, String clientName)
    {
        this.questId = questId;
        this.questName = questName;
        this.clientName = clientName;
    }

    public int getQuestId()
    {
        return questId;
    }

    public String getQuestName()
    {
        return questName;
    }

    public String getClientName()
    {
        return clientName;
    }
}
