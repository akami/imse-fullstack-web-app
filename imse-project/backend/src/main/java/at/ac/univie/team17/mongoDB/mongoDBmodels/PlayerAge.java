package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class PlayerAge
{
    private int playerId;
    private int age;

    public PlayerAge(int playerId, int age)
    {
        this.playerId = playerId;
        this.age = age;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public int getAge()
    {
        return age;
    }
}
