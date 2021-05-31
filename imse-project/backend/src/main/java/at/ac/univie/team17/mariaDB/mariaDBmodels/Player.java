package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Player
{
    private int playerId;
    private String username;
    private String emailAddress;

    public Player(int playerId, String username, String emailAddress)
    {
        this.playerId = playerId;
        this.username = username;
        this.emailAddress = emailAddress;
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
}
