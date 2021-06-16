package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class CharacterDataGenerator
{
    private static final int MINIMAL_ATTACK = 5;
    private static final int ATTACK_RANGE = 5;
    private static final int MINIMAL_LIFEPOINTS = 10;
    private static final int LIFEPOINTS_RANGE = 10;

    public static ArrayList<GameCharacter> generateCharacterData(int characterAmount, int playerAmount, int characterClassAmount)
    {
        ArrayList<GameCharacter> gameCharacters = new ArrayList<>();

        Faker stringCreator = new Faker();
        Random random = new Random();
        for (int i = 0; i < characterAmount; ++i)
        {
            gameCharacters.add(new GameCharacter(i, stringCreator.name().firstName(), random.nextInt(ATTACK_RANGE) + MINIMAL_ATTACK,
                    random.nextInt(LIFEPOINTS_RANGE) + MINIMAL_LIFEPOINTS, random.nextInt(playerAmount),
                    random.nextInt(characterClassAmount)));
        }
        return gameCharacters;
    }
}
