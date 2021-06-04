package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import com.github.javafaker.Faker;

import java.util.ArrayList;

public class QuestDataGenerator
{
    /*
        questrewardid = questid for simplicity
     */
    public static ArrayList<Quest> generateQuestData(int questAmount)
    {
        ArrayList<Quest> quests = new ArrayList<>();

        Faker stringCreator = new Faker();
        String questName;
        for (int i = 0; i < questAmount; ++i)
        {
            questName = stringCreator.shakespeare().asYouLikeItQuote();
            while (questName.contains("'"))
            {
                questName = stringCreator.shakespeare().asYouLikeItQuote();
            }
            quests.add(new Quest(i, questName, stringCreator.name().firstName(), i));
        }
        return quests;
    }
}
