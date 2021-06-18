package at.ac.univie.team17.mariaDB.mariaDBmodels;

import java.util.Objects;

public class AlliedMonsters
{
    private int monsterId1;
    private int monsterId2;

    public AlliedMonsters(int monsterId1, int monsterId2)
    {
        this.monsterId1 = monsterId1;
        this.monsterId2 = monsterId2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlliedMonsters that = (AlliedMonsters) o;
        return monsterId1 == that.monsterId1 && monsterId2 == that.monsterId2;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(monsterId1, monsterId2);
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
