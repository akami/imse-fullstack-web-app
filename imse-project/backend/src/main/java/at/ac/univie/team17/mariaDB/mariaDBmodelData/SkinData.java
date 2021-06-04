package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;

import java.util.ArrayList;

public class SkinData
{
    public static ArrayList<Skin> getSkinData()
    {
        ArrayList<Skin> skins = new ArrayList<>();
        skins.add(new Skin(0, 0, "Merlin", 13));
        skins.add(new Skin(1, 0, "Morgana", 13));
        skins.add(new Skin(2, 1, "Jeanne", 13));
        skins.add(new Skin(3, 1, "Siegfried", 13));
        skins.add(new Skin(4, 2, "Antonio", 13));
        skins.add(new Skin(5, 2, "Nicolas", 13));
        skins.add(new Skin(6, 3, "Arthur", 13));
        skins.add(new Skin(7, 3, "Hulk", 13));
        skins.add(new Skin(8, 4, "Arrow", 13));
        skins.add(new Skin(9, 4, "Genghis", 13));
        skins.add(new Skin(10, 5, "Tristan", 13));
        skins.add(new Skin(11, 5, "Isolde", 13));
        return skins;
    }
}
