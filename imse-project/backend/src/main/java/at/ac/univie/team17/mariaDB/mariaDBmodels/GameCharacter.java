package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class GameCharacter
{
    private int characterId;
    private String characterName;
    private int attack;
    private int lifepointAmount;
    private int playerId;
    private int characterClassId;

    public GameCharacter(int characterId, String characterName, int attack, int lifepointAmount, int playerId, int characterClassId)
    {
        this.characterId = characterId;
        this.characterName = characterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
        this.playerId = playerId;
        this.characterClassId = characterClassId;
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

    public int getPlayerId()
    {
        return playerId;
    }

    public int getCharacterClassId()
    {
        return characterClassId;
    }

    public void setCharacterId(int i) {
        this.characterId = i;
    }
}
