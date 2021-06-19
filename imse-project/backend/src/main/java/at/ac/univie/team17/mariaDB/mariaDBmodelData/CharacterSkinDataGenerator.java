package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterSkin;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;

import java.util.ArrayList;
import java.util.Random;

public class CharacterSkinDataGenerator
{
    public static ArrayList<CharacterSkin> generateCharacterSkinsData(int characterSkinsAmount,
                                                                      ArrayList<GameCharacter> characters, ArrayList<Skin> skins)
    {
        ArrayList<CharacterSkin> characterSkins = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < characterSkinsAmount; ++i)
        {
            CharacterSkin characterSkin = new CharacterSkin(random.nextInt(characters.size()) + 1, random.nextInt(skins.size()));
            if (!characterSkins.contains(characterSkin) &&
                    skins.get(characterSkin.getSkinId()).getClassId() == characters.get(characterSkin.getCharacterId()).getCharacterClassId())
            {
                characterSkins.add(characterSkin);
            }
        }
        return characterSkins;
    }
}
