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
        skins.add(new Skin(2, 0, "Jeanne", 13));
        skins.add(new Skin(3, 0, "Siegfried", 13));
        skins.add(new Skin(4, 0, "Antonio", 13));
        skins.add(new Skin(5, 1, "Nicolas", 13));
        skins.add(new Skin(6, 1, "Arthur", 13));
        skins.add(new Skin(7, 1, "Hulk", 13));
        skins.add(new Skin(8, 1, "Arrow", 13));
        skins.add(new Skin(9, 1, "Genghis", 13));
        skins.add(new Skin(10, 2, "Marianne", 13));
        skins.add(new Skin(11, 2, "Isolde", 13));
        skins.add(new Skin(12, 2, "Alise", 13));
        skins.add(new Skin(13, 2, "Amalur", 13));
        skins.add(new Skin(14, 2, "Thor", 13));
        skins.add(new Skin(15, 3, "Link", 13));
        skins.add(new Skin(16, 3, "Marianne", 13));
        skins.add(new Skin(17, 3, "Katarina", 13));
        skins.add(new Skin(18, 3, "Darius", 13));
        skins.add(new Skin(19, 3, "Caesar", 13));
        skins.add(new Skin(20, 4, "Tuno", 13));
        skins.add(new Skin(21, 4, "Chimichurri", 13));
        skins.add(new Skin(22, 4, "Siegelind", 13));
        skins.add(new Skin(23, 4, "Rosalind", 13));
        skins.add(new Skin(24, 4, "Franklin", 13));
        skins.add(new Skin(25, 5, "Lise", 13));
        skins.add(new Skin(26, 5, "Kalpana", 13));
        skins.add(new Skin(27, 5, "Mary", 13));
        skins.add(new Skin(28, 5, "Blackwell", 13));
        skins.add(new Skin(29, 5, "Clarissa", 13));

        return skins;
    }
}
