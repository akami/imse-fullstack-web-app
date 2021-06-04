package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;

import java.util.ArrayList;

public class CharacterClassData
{
    public static ArrayList<CharacterClass> getCharacterClassData()
    {
        ArrayList<CharacterClass> characterClasses = new ArrayList<>();
        characterClasses.add(new CharacterClass(0, 10, 17, "Mage"));
        characterClasses.add(new CharacterClass(1, 5, 34, "Knight"));
        characterClasses.add(new CharacterClass(2, 4, 25, "Priest"));
        characterClasses.add(new CharacterClass(3, 7, 29, "Fighter"));
        characterClasses.add(new CharacterClass(4, 8, 23, "Ranger"));
        characterClasses.add(new CharacterClass(5, 6, 27, "Thief"));
        return characterClasses;
    }
}
