package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;

public class MonsterQueries
{
    public static String getInsertMonsterQuery(Monster monster)
    {
        return "INSERT INTO monster(monster_id, monster_name, attack, lifepoints, challenge_rating, monster_loot_id)" +
                " VALUES ('" + monster.getMonsterId() + "', '" + monster.getMonsterName() + "', '" + monster.getAttack() +
                "', '" + monster.getLifepointAmount() + "', '" + monster.getChallengeRating() + "', '" + monster.getMonsterLootId() + "');";
    }

    public static String getSelectAllMonstersQuery()
    {
        return "SELECT * FROM monster;";
    }

    public static String getSelectMonsterFromIdQuery(int id)
    {
        return "SELECT * FROM monster WHERE monster_id = " + id + ";";
    }

    public static String getCreateMonsterTableQuery()
    {
        return "CREATE TABLE monster(monster_id INT, monster_name CHAR(30), attack INT, lifepoints INT, " +
                "challenge_rating INT, monster_loot_id INT, PRIMARY KEY (monster_id), " +
                "CONSTRAINT monster_fk_monster_loot FOREIGN KEY (monster_loot_id) REFERENCES monster_loot(monster_loot_id) " +
                "ON DELETE CASCADE ON UPDATE RESTRICT);";
    }

    public static String getDropMonsterTableQuery()
    {
        return "DROP TABLE monster;";
    }
}
