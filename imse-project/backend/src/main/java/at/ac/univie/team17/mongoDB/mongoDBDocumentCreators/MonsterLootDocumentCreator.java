package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLoot;
import org.bson.Document;

public class MonsterLootDocumentCreator
{

    public static Document getMonsterLootDocument(MongoMonsterLoot monsterLoot)
    {
        Document monsterLootDocument = new Document();
        monsterLootDocument.append("goldAmount", monsterLoot.getGoldAmount());
        monsterLootDocument.append("experienceAmount", monsterLoot.getExperienceAmount());
        return monsterLootDocument;
    }

    public static MongoMonsterLoot getMonsterLootFromDocument(Document document)
    {
        return new MongoMonsterLoot(document.getInteger("goldAmount"), document.getInteger("experienceAmount"));
    }
}
