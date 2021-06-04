package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class GoldOffer
{
    private int goldOfferId;
    private boolean accepted;
    private boolean successful;
    private int goldAmount;
    private int playerId;

    public GoldOffer(int goldOfferId, boolean accepted, boolean successful, int goldAmount, int playerId)
    {
        this.goldOfferId = goldOfferId;
        this.accepted = accepted;
        this.successful = successful;
        this.goldAmount = goldAmount;
        this.playerId = playerId;
    }

    public int getGoldOfferId()
    {
        return goldOfferId;
    }

    public boolean isAccepted()
    {
        return accepted;
    }

    public boolean isSuccessful()
    {
        return successful;
    }

    public int getGoldAmount()
    {
        return goldAmount;
    }

    public int getPlayerId()
    {
        return playerId;
    }
}
