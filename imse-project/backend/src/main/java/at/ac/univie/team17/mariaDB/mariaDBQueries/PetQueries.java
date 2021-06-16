package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.sharedDataModels.Pet;

public class PetQueries
{
    public static String getInsertPetQuery(Pet pet)
    {
        return "INSERT INTO pet(pet_id, pet_name, gold_price) VALUES ('" + pet.getPetId() + "', '" + pet.getPetName() +
                "', '" + pet.getGoldPrice() + "');";
    }

    public static String getSelectAllPetsQuery()
    {
        return "SELECT * FROM pet;";
    }

    public static String getSelectPetFromIdQuery(int id)
    {
        return "SELECT * FROM pet WHERE pet_id = " + id + ";";
    }

    public static String getCreatePetTableQuery()
    {
        return "CREATE TABLE pet(pet_id INT, pet_name CHAR(30), gold_price INT, PRIMARY KEY (pet_id));";
    }

    public static String getDropPetTableQuery()
    {
        return "DROP TABLE pet;";
    }
}
