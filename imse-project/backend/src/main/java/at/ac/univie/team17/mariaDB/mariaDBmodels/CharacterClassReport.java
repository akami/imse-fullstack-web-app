package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterClassReport
{
    private int chracterClassId;
    private String characterClassName;
    private int characterAmount;

    public CharacterClassReport(int chracterClassId, String characterClassName, int characterAmount)
    {
        this.chracterClassId = chracterClassId;
        this.characterClassName = characterClassName;
        this.characterAmount = characterAmount;
    }

    public int getChracterClassId()
    {
        return chracterClassId;
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
