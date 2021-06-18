package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;

import java.util.ArrayList;
import java.util.Random;

public class CharacterSkinDataGenerator
{
    public static ArrayList<CharacterSkin> generateCharacterSkinsData(int characterSkinsAmount, int characterAmount, int skinAmount)
    {
        ArrayList<CharacterSkin> characterSkins = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < characterSkinsAmount; ++i)
        {
            CharacterSkin characterSkin = new CharacterSkin(random.nextInt(characterAmount) + 1, random.nextInt(skinAmount));
            if (!characterSkins.contains(characterSkin))
            {
                characterSkins.add(characterSkin);
            }
        }
        return characterSkins;
    }
}
