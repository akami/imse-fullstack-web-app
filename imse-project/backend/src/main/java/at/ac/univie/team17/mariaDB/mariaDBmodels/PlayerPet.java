package at.ac.univie.team17.mariaDB.mariaDBmodels;

import java.util.Objects;

public class PlayerPet
{
    private int playerId;
    private int petId;

    public PlayerPet(int playerId, int petId)
    {
        this.playerId = playerId;
        this.petId = petId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPet playerPet = (PlayerPet) o;
        return playerId == playerPet.playerId && petId == playerPet.petId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(playerId, petId);
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
