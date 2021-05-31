package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class CharacterClass
{
    private int classId;
    private int bonusAttack;
    private int bonusLifepoints;
    private String className;

    public CharacterClass(int classId, int bonusAttack, int bonusLifepoints, String className)
    {
        this.classId = classId;
        this.bonusAttack = bonusAttack;
        this.bonusLifepoints = bonusLifepoints;
        this.className = className;
    }

    public int getClassId()
    {
        return classId;
    }

    public int getBonusAttack()
    {
        return bonusAttack;
    }

    public int getBonusLifepoints()
    {
        return bonusLifepoints;
    }

    public String getClassName()
    {
        return className;
    }
}
