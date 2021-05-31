package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Character
{
    private int characterId;
    private String characterName;
    private int attack;
    private int lifepointAmount;

    public Character(int characterId, String characterName, int attack, int lifepointAmount)
    {
        this.characterId = characterId;
        this.characterName = characterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public String getCharacterName()
    {
        return characterName;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getLifepointAmount()
    {
        return lifepointAmount;
    }
}
