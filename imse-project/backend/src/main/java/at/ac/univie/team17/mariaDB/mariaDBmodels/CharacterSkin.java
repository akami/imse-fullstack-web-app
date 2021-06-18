package at.ac.univie.team17.mariaDB.mariaDBmodels;

import java.util.Objects;

public class CharacterSkin
{
    private final int characterId;
    private final int skinId;

    public CharacterSkin(int characterId, int skinId)
    {
        this.characterId = characterId;
        this.skinId = skinId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSkin that = (CharacterSkin) o;
        return characterId == that.characterId && skinId == that.skinId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(characterId, skinId);
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
