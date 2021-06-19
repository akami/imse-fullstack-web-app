package at.ac.univie.team17.mongoDB.mongoDBmodels;

import at.ac.univie.team17.sharedDataModels.Pet;

import java.util.ArrayList;

public class MongoPlayerPet
{
    private int playerId;
    private ArrayList<Pet> boughtPets;

    public MongoPlayerPet(int playerId, ArrayList<Pet> boughtPets)
    {
        this.playerId = playerId;
        this.boughtPets = boughtPets;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public ArrayList<Pet> getBoughtPets()
    {
        return boughtPets;
    }
}
