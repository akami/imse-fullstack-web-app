package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.PlayerPet;

public class PlayerPetQueries
{
    public static String getInsertPlayerPetQuery(PlayerPet playerPet)
    {
        return "INSERT INTO player_pet (player_id, pet_id) VALUES ('" + playerPet.getPlayerId() + "', '" +
                playerPet.getPetId() + "');";
    }

    public static String getSelectAllPlayerPetsQuery()
    {
        return "SELECT * FROM player_pet;";
    }

    public static String getSelectPlayerPetFromIdQuery(int playerId, int petId)
    {
        return "SELECT * FROM player_pet WHERE player_id = " + playerId + " AND pet_id = " + petId + ";";
    }

    public static String getSelectPlayerPetFromPlayerIdQuery(int playerId)
    {
        return "SELECT pet.* FROM " +
                "(SELECT * FROM player_pet WHERE player_id = " + playerId + ") AS bought_pets " +
                "JOIN pet ON bought_pets.pet_id = pet.pet_id;";
    }

    public static String getCreatePlayerPetsTableQuery()
    {
        return "CREATE TABLE player_pet (player_id INT, pet_id INT, PRIMARY KEY (player_id, pet_id), CONSTRAINT player_pet_fk_player " +
                "FOREIGN KEY (player_id) REFERENCES player(player_id) ON DELETE CASCADE ON UPDATE RESTRICT, " +
                "CONSTRAINT player_pet_fk_pet FOREIGN KEY (pet_id) REFERENCES pet(pet_id) ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropPlayerPetTableQuery()
    {
        return "DROP TABLE player_pet;";
    }
}
