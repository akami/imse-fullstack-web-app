package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.MonsterLoot;

import java.util.ArrayList;
import java.util.Random;

public class MonsterLootDataGenerator
{
    private static final int MINIMAL_GOLD = 2;
    private static final int GOLD_RANGE = 5;
    private static final int MINIMAL_EXPERIENCE = 10;
    private static final int EXPERIENCE_RANGE = 7;

    public static ArrayList<MonsterLoot> generateMonsterLootData(int monsterLootAmount)
    {
        ArrayList<MonsterLoot> monsterLoots = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < monsterLootAmount; ++i)
        {
            monsterLoots.add(new MonsterLoot(i, random.nextInt(GOLD_RANGE) + MINIMAL_GOLD,
                    random.nextInt(EXPERIENCE_RANGE) + MINIMAL_EXPERIENCE));
        }
        return monsterLoots;
    }
}
