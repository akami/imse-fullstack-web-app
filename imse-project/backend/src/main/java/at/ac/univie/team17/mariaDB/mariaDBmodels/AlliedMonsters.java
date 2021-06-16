package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class AlliedMonsters
{
    private int monsterId1;
    private int monsterId2;

    public AlliedMonsters(int monsterId1, int monsterId2)
    {
        this.monsterId1 = monsterId1;
        this.monsterId2 = monsterId2;
    }

    public int getMonsterId1()
    {
        return monsterId1;
    }

    public int getMonsterId2()
    {
        return monsterId2;
    }
}
