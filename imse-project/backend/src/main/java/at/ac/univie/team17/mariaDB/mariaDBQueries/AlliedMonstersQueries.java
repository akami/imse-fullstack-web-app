package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.AlliedMonsters;

public class AlliedMonstersQueries
{
    public static String getInsertAlliedMonsterQuery(AlliedMonsters monster)
    {
        return "INSERT INTO allied_monster(monster_id1, monster_id2)" +
                " VALUES ('" + monster.getMonsterId1() + "', '" + monster.getMonsterId2() + "');";
    }

    public static String getSelectAllAlliedMonstersQuery()
    {
        return "SELECT * FROM allied_monster;";
    }

    public static String getSelectAlliedMonsterIdsFromIdQuery(int id)
    {
        return "SELECT monster_id2 FROM allied_monster WHERE monster_id1 = " + id + ";";
    }

    public static String getCreateAlliedMonsterTableQuery()
    {
        return "CREATE TABLE allied_monster(monster_id1 INT, monster_id2 INT, PRIMARY KEY (monster_id1, monster_id2), " +
                "CONSTRAINT monster_fk_monster1 FOREIGN KEY (monster_id1) REFERENCES monster(monster_id) " +
                "ON DELETE CASCADE ON UPDATE RESTRICT, CONSTRAINT monster_fk_monster2 FOREIGN KEY (monster_id2) REFERENCES monster(monster_id)" +
                "ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropAlliedMonsterTableQuery()
    {
        return "DROP TABLE allied_monster;";
    }
}
