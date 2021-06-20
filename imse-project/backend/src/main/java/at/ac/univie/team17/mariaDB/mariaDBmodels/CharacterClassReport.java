package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterClassReport
{
    private int characterClassId;
    private String characterClassName;
    private int characterAmount;

    public CharacterClassReport(int characterClassId, String characterClassName, int characterAmount)
    {
        this.characterClassId = characterClassId;
        this.characterClassName = characterClassName;
        this.characterAmount = characterAmount;
    }

    public int getCharacterClassId()
    {
        return characterClassId;
    }

    public String getCharacterClassName()
    {
        return characterClassName;
    }

    public int getCharacterAmount()
    {
        return characterAmount;
    }
}
