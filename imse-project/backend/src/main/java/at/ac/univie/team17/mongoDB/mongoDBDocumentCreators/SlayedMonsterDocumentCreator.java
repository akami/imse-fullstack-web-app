package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

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

    private static Document createSlayedMonsterDocument(SlayedMonsters slayedMonster)
    {
        Document slayerMonsterDocument = new Document();
        slayerMonsterDocument.append("_id", slayedMonster.getMonsterId());
        slayerMonsterDocument.append("monsterLoot", MonsterLootDocumentCreator.getMonsterLootDocument(slayedMonster.getMonsterLoot()));
        slayerMonsterDocument.append("slayAmount", slayedMonster.getSlayAmount());
        return slayerMonsterDocument;
    }
}
