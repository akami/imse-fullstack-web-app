package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLoot;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import at.ac.univie.team17.mongoDB.mongoDBmodels.SlayedMonsters;
import org.bson.Document;

import java.util.ArrayList;

public class SlayedMonsterDocumentCreator
{

    public static ArrayList<Document> getSlayedMonsterDocuments(ArrayList<SlayedMonsters> slayedMonsters)
    {
        ArrayList<Document> slayedMonsterDocuments = new ArrayList<>();
        for (SlayedMonsters slayedMonster : slayedMonsters)
        {
            slayedMonsterDocuments.add(createSlayedMonsterDocument(slayedMonster));
        }
        return slayedMonsterDocuments;
    }

    public static Document createSlayedMonsterDocument(SlayedMonsters slayedMonster)
    {
        Document slayerMonsterDocument = new Document();
        slayerMonsterDocument.append("_id", slayedMonster.getMonsterId());
        slayerMonsterDocument.append("monsterLoot", MonsterLootDocumentCreator.getMonsterLootDocument(slayedMonster.getMonsterLoot()));
        slayerMonsterDocument.append("slayAmount", slayedMonster.getSlayAmount());
        return slayerMonsterDocument;
    }

    public static ArrayList<SlayedMonsters> getSlayedMonstersFromDocument(ArrayList<Document> documents)
    {
        ArrayList<SlayedMonsters> slayedMonsters = new ArrayList<>();
        for (Document document : documents)
        {
            slayedMonsters.add(getSlayedMonsterFromDocument(document));
        }
        return slayedMonsters;
    }

    public static SlayedMonsters getSlayedMonsterFromDocument(Document document)
    {
        MongoMonsterLoot monsterLoot = MonsterLootDocumentCreator.getMonsterLootFromDocument((Document) document.get("monsterLoot"));

        return new SlayedMonsters(document.getInteger("_id"), monsterLoot, document.getInteger("slayAmount"));
    }
}
