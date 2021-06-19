package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.sharedDataModels.Pet;

import java.util.ArrayList;

public class MongoPlayer
{
    private int playerId;
    private String username;
    private int age;
    private String emailAddress;
    private ArrayList<Pet> boughtPets;
    private ArrayList<MongoCharacter> createdCharacters;
    private ArrayList<MongoGoldOffer> mongoGoldOffers;

    public MongoPlayer(int playerId, String username, int age, String emailAddress, ArrayList<Pet> boughtPets,
                       ArrayList<MongoCharacter> createdCharacters, ArrayList<MongoGoldOffer> mongoGoldOffers)
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

    public ArrayList<MongoCharacter> getCreatedCharacters()
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
}
