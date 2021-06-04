package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterSkin
{
    private final int characterId;
    private final int skinId;

    public CharacterSkin(int characterId, int skinId)
    {
        this.characterId = characterId;
        this.skinId = skinId;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public int getSkinId()
    {
        return skinId;
    }
}
