package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.sharedDataModels.Pet;

import java.util.ArrayList;

public class PetData
{
    public static ArrayList<Pet> getPetData()
    {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet(0, "Chicky", 10));
        pets.add(new Pet(1, "Enton", 12));
        pets.add(new Pet(2, "Catto", 15));
        pets.add(new Pet(3, "Wauwau", 13));
        pets.add(new Pet(4, "Moon", 17));
        pets.add(new Pet(5, "Owly", 14));
        pets.add(new Pet(6, "Blub", 13));
        pets.add(new Pet(7, "Puppet", 12));
        pets.add(new Pet(8, "Vistha", 18));
        pets.add(new Pet(9, "Pegasus", 25));
        pets.add(new Pet(10, "Racoona Matata", 25));
        return pets;
    }
}
