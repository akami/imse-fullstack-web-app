package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.PlayerPet;

import java.util.ArrayList;
import java.util.Random;

public class PlayerPetDataGenerator
{
    public static ArrayList<PlayerPet> generatePlayerPetsData(int playerPetsAmount, int playerAmount, int petAmount)
    {
        ArrayList<PlayerPet> playerPets = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < playerPetsAmount; ++i)
        {
            playerPets.add(new PlayerPet(random.nextInt(playerAmount), random.nextInt(petAmount)));
        }
        return playerPets;
    }
}
