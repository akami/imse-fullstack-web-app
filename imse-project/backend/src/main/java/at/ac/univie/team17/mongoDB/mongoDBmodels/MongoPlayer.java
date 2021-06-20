package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.sharedDataModels.Pet;

import java.util.ArrayList;

public class MongoPlayer
{
    private int playerId;
    private String username;
    private int age;
    private String emailAddress;
    private ArrayList<Pet> boughtPets;
    private ArrayList<Integer> createdCharacters;
    private ArrayList<MongoGoldOffer> mongoGoldOffers;

    public MongoPlayer(int playerId, String username, int age, String emailAddress, ArrayList<Pet> boughtPets,
                       ArrayList<Integer> createdCharacters, ArrayList<MongoGoldOffer> mongoGoldOffers)
    {
        this.playerId = playerId;
        this.username = username;
        this.age = age;
        this.emailAddress = emailAddress;
        this.boughtPets = boughtPets;
        this.createdCharacters = createdCharacters;
        this.mongoGoldOffers = mongoGoldOffers;
    }

    @Override
    public String toString()
    {
        return "MongoPlayer{" +
                "playerId=" + playerId +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", boughtPets=" + boughtPets +
                ", createdCharacters=" + createdCharacters +
                ", mongoGoldOffers=" + mongoGoldOffers +
                '}';
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public ArrayList<Pet> getBoughtPets()
    {
        return boughtPets;
    }

    public ArrayList<Integer> getCreatedCharacters()
    {
        return createdCharacters;
    }

    public ArrayList<MongoGoldOffer> getGoldOffers()
    {
        return mongoGoldOffers;
    }

    public Object getAge()
    {
        return age;
    }

    public Integer getTotalGold()
    {
        final Integer defaultGold = 200;
        Integer goldOfferGold = 0, petGold = 0, skinGold = 0, questGold = 0, monsterGold = 0;
        for (MongoGoldOffer mongoGoldOffer: mongoGoldOffers)
        {
            goldOfferGold += mongoGoldOffer.getGoldAmount();
        }
        for (Pet pet : boughtPets)
        {
            petGold += pet.getGoldPrice();
        }
        for (Integer mongoCharacterid : createdCharacters)
        {
            MongoCharacter mongoCharacter = MongoCharacterQueries.getMongoCharacterFromId(mongoCharacterid);
            for (MongoSkin skin : mongoCharacter.getBoughtSkins())
            {
                skinGold += skin.getGoldPrice();
            }
            for (SlayedMonsters slayedMonsters : mongoCharacter.getSlayedMonsters())
            {
                monsterGold += slayedMonsters.getSlayAmount() * slayedMonsters.getMonsterLoot().getGoldAmount();
            }
            for (MongoQuest mongoQuest : mongoCharacter.getCompletedQuests())
            {
                questGold += mongoQuest.getQuestReward().getGoldAmount();
            }
        }

        return defaultGold + goldOfferGold + questGold + monsterGold - petGold - skinGold;
    }
}
