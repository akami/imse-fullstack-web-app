package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterQuest
{
    private final int characterId;
    private final int questId;

    public CharacterQuest(int characterId, int questId)
    {
        this.characterId = characterId;
        this.questId = questId;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public int getQuestId()
    {
        return questId;
    }
}
