package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Player
{
    private int playerId;
    private String username;
    private int age;
    private String emailAddress;

    public Player(int playerId, String username, int age, String emailAddress)
    {
        this.playerId = playerId;
        this.username = username;
        this.age = age;
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

    public int getAge()
    {
        return age;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setPlayerId(int i) {
        this.playerId = i;
    }
}
