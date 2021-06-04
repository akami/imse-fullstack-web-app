package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Monster;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class MonsterDataGenerator
{
    private static final int MINIMAL_ATTACK = 3;
    private static final int ATTACK_RANGE = 8;
    private static final int MINIMAL_LIFEPOINTS = 12;
    private static final int LIFEPOINTS_RANGE = 15;
    private static final int MAXIMAL_CHALLENGE_RATING = 10;

    /*
        monsterid = monster loot id for simplicity
     */
    public static ArrayList<Monster> generateMonsterData(int monsterAmount, int characterAmount)
    {
        ArrayList<Monster> monsters = new ArrayList<>();

        Faker stringCreator = new Faker();
        Random random = new Random();
        String monsterName = "";
        for (int i = 0; i < monsterAmount; ++i)
        {
            monsterName = stringCreator.funnyName().name();
            while (monsterName.contains("'"))
            {
                monsterName = stringCreator.funnyName().name();
            }
            monsters.add(new Monster(i, monsterName, random.nextInt(ATTACK_RANGE) + MINIMAL_ATTACK,
                    random.nextInt(LIFEPOINTS_RANGE) + MINIMAL_LIFEPOINTS, random.nextInt(MAXIMAL_CHALLENGE_RATING),
                    random.nextInt(characterAmount), i));
        }
        return monsters;
    }
}
