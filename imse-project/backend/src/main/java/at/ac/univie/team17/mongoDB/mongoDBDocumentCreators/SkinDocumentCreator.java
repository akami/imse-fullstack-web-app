package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import org.bson.Document;

import java.util.ArrayList;

public class SkinDocumentCreator
{
    public static ArrayList<Document> getSkinDocuments(ArrayList<MongoSkin> skins)
    {
        ArrayList<Document> skinDocuments = new ArrayList<>();
        for (MongoSkin skin : skins)
        {
            skinDocuments.add(createSkinDocument(skin));
        }
        return skinDocuments;
    }

    public static Document createSkinDocument(MongoSkin skin)
    {
        Document skinDocument = new Document();
        skinDocument.append("_id", skin.getSkinId());
        skinDocument.append("skinName", skin.getSkinName());
        skinDocument.append("goldPrice", skin.getGoldPrice());
        return skinDocument;
    }

    public static ArrayList<MongoSkin> getSkinsFromDocument(ArrayList<Document> documents)
    {
        ArrayList<MongoSkin> mongoSkins = new ArrayList<>();
        for (Document document : documents)
        {
            mongoSkins.add(getSkinFromDocument(document));
        }
        return mongoSkins;
    }



    public static MongoSkin getSkinFromDocument(Document document)
    {
        return new MongoSkin(document.getInteger("_id"), document.getString("skinName"), document.getInteger("goldPrice"));
    }
}
