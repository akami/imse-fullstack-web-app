package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class PlayerPet
{
    private int playerId;
    private int petId;

    public PlayerPet(int playerId, int petId)
    {
        this.playerId = playerId;
        this.petId = petId;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public int getPetId()
    {
        return petId;
    }
}
