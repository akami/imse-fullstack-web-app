package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import org.bson.Document;

import java.util.ArrayList;

public class CharacterClassDocumentCreator
{
    public static final String CHARACTER_CLASS_COLLECTION_NAME = "characterClass";


    public static Document createCharacterClassDocument(CharacterClass characterClass, ArrayList<Skin> skins)
    {
        Document characterClassDocument = new Document();
        characterClassDocument.append("_id", characterClass.getClassId());
        characterClassDocument.append("className", characterClass.getClassName());
        characterClassDocument.append("bonusAttack", characterClass.getBonusAttack());
        characterClassDocument.append("bonusLifepoints", characterClass.getBonusLifepoints());
        characterClassDocument.append("skins", skins);
        return characterClassDocument;
    }
}
