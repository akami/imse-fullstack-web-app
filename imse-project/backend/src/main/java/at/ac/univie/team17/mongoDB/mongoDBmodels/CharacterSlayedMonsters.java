package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.List;

public class CharacterSlayedMonsters
{
    private int characterId;
    List<SlayedMonsters> slayedMonsters;

    public CharacterSlayedMonsters(int characterId, List<SlayedMonsters> slayedMonsters)
    {
        this.characterId = characterId;
        this.slayedMonsters = slayedMonsters;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public List<SlayedMonsters> getSlayedMonsters()
    {
        return slayedMonsters;
    }
}
