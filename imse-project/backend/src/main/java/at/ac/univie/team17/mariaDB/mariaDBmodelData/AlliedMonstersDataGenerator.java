package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.AlliedMonsters;

import java.util.ArrayList;
import java.util.Random;

public class AlliedMonstersDataGenerator
{
    public static ArrayList<AlliedMonsters> generateAlliedMonstersData(int alliedMonsterAmount, int monsterAmount)
    {
        ArrayList<AlliedMonsters> alliedMonsters = new ArrayList<>();

        Random random = new Random();

        int monsterid1, monsterid2;

        for (int i = 0; i < alliedMonsterAmount; ++i)
        {
            monsterid1 = random.nextInt(monsterAmount);
            monsterid2 = random.nextInt(monsterAmount);

            AlliedMonsters alliedMonster = new AlliedMonsters(monsterid1, monsterid2);
            if (monsterid1 != monsterid2 && !alliedMonsters.contains(alliedMonster))
            {
                alliedMonsters.add(alliedMonster);
            }
        }
        return alliedMonsters;
    }
}
