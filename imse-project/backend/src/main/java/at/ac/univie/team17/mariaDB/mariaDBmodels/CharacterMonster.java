package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterMonster
{
    private int monsterId;
    private int characterId;
    private int slayAmount;

    public CharacterMonster(int monsterId, int characterId, int slayAmount)
    {
        this.monsterId = monsterId;
        this.characterId = characterId;
        this.slayAmount = slayAmount;
    }

    public int getMonsterId()
    {
        return monsterId;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public int getSlayAmount()
    {
        return slayAmount;
    }
}
