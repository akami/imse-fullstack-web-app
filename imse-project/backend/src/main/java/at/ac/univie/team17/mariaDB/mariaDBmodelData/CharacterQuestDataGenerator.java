package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterQuest;

import java.util.ArrayList;
import java.util.Random;

public class CharacterQuestDataGenerator
{
    public static ArrayList<CharacterQuest> generateCharacterQuestData(int characterQuestAmount, int characterAmount, int questAmount)
    {
        ArrayList<CharacterQuest> characterQuests = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < characterQuestAmount; ++i)
        {
            characterQuests.add(new CharacterQuest(random.nextInt(characterAmount) + 1, random.nextInt(questAmount)));
        }
        return characterQuests;
    }
}
