package at.ac.univie.team17.mongoDB.mongoDBmodels;

import java.util.ArrayList;

public class MongoCharacter
{
    private int characterId;
    private String characterName;
    private int attack;
    private int lifepointAmount;
    private MongoCharacterClass characterClass;
    private ArrayList<MongoSkin> boughtSkins;
    private ArrayList<MongoQuest> completedQuests;
    private ArrayList<SlayedMonsters> slayedMonsters;
    private PlayerAge playerAge;

    public MongoCharacter(int characterId, String characterName, int attack, int lifepointAmount, MongoCharacterClass characterClass,
                          ArrayList<MongoSkin> boughtSkins, ArrayList<MongoQuest> completedQuests, ArrayList<SlayedMonsters> slayedMonsters,
                          PlayerAge playerAge)
    {
        this.characterId = characterId;
        this.characterName = characterName;
        this.attack = attack;
        this.lifepointAmount = lifepointAmount;
        this.characterClass = characterClass;
        this.boughtSkins = boughtSkins;
        this.completedQuests = completedQuests;
        this.slayedMonsters = slayedMonsters;
        this.playerAge = playerAge;
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

    public MongoCharacterClass getCharacterClass()
    {
        return characterClass;
    }

    public ArrayList<MongoSkin> getBoughtSkins()
    {
        return boughtSkins;
    }

    public ArrayList<MongoQuest> getCompletedQuests()
    {
        return completedQuests;
    }

    public ArrayList<SlayedMonsters> getSlayedMonsters()
    {
        return slayedMonsters;
    }

    public PlayerAge getPlayerAge()
    {
        return playerAge;
    }
}
