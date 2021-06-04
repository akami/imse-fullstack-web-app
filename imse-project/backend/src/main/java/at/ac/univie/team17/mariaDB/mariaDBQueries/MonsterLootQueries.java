package at.ac.univie.team17.mariaDB.mariaDBQueries;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;

public class MonsterLootQueries
{
    public static String getInsertMonsterLootQuery(MonsterLoot monsterLoot)
    {
        return "INSERT INTO monster_loot(monster_loot_id, gold_amount, experience_amount) VALUES ('" +
                monsterLoot.getLootId() + "', '" + monsterLoot.getGoldAmount() + "', '" + monsterLoot.getExperienceAmount() + "');";
    }

    public static String getSelectAllMonsterLootsQuery()
    {
        return "SELECT * FROM monster_loot;";
    }

    public static String getSelectMonsterLootFromIdQuery(int id)
    {
        return "SELECT * FROM monster_loot WHERE monster_loot_id = " + id + ";";
    }

    public static String getCreateMonsterLootTableQuery()
    {
        return "CREATE TABLE monster_loot(monster_loot_id INT, gold_amount INT, experience_amount INT, PRIMARY KEY (monster_loot_id));";
    }
}
