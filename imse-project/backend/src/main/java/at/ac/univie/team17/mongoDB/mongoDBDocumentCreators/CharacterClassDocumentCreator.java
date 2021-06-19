package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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
        characterClassDocument.append("skins", SkinDocumentCreator.getSkinDocuments(MongoSkin.getMongoSkinsFromSkin(skins)));
        return characterClassDocument;
    }

    public static Document createCharacterClassDocument(MongoCharacterClass characterClass, ArrayList<Skin> skins)
    {
        Document characterClassDocument = new Document();
        characterClassDocument.append("_id", characterClass.getClassId());
        characterClassDocument.append("className", characterClass.getClassName());
        characterClassDocument.append("bonusAttack", characterClass.getBonusAttack());
        characterClassDocument.append("bonusLifepoints", characterClass.getBonusLifepoints());
        characterClassDocument.append("skins", SkinDocumentCreator.getSkinDocuments(MongoSkin.getMongoSkinsFromSkin(skins)));
        return characterClassDocument;
    }

    public static ArrayList<MongoCharacterClass> getCharacterClassesFromDocuments(ArrayList<Document> documents)
    {
        ArrayList<MongoCharacterClass> mongoCharacterClasses = new ArrayList<>();
        for (Document document : documents)
        {
            mongoCharacterClasses.add(getCharacterClassFromDocument(document));
        }
        return mongoCharacterClasses;
    }

    public static MongoCharacterClass getCharacterClassFromDocument(Document documents)
    {
        ArrayList<MongoSkin> skins = SkinDocumentCreator.getSkinsFromDocument((ArrayList<Document>)documents.get("skins"));

        return new MongoCharacterClass(documents.getInteger("_id"), documents.getInteger("bonusAttack"),
                documents.getInteger("bonusLifepoints"), documents.getString("className"), skins);
    }

    public static MongoCharacterClass getCharacterClassWithSkinsFromDocument(Document documents)
    {
        ArrayList<MongoSkin> skins = SkinDocumentCreator.getSkinsFromDocument((ArrayList<Document>)documents.get("skins"));

        return new MongoCharacterClass(documents.getInteger("_id"), 0, 0, "", skins);
    }

    public static List<MongoSkin> getSkinsFromCharacterClassFromDocument(Document documents)
    {
        return SkinDocumentCreator.getSkinsFromDocument((ArrayList<Document>)documents.get("skins"));
    }
}
