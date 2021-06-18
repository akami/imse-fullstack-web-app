package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonster;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoMonsterLoot;
import org.bson.Document;

import java.util.ArrayList;

public class MonsterDocumentCreator
{
    public static final String MONSTER_COLLECTION_NAME = "monster";

    public static Document createMonsterDocument(Monster monster, MonsterLoot monsterLoot,
                                                 ArrayList<Integer> possibleAlliedMonsters)
    {
        Document questDocument = new Document();
        questDocument.append("_id", monster.getMonsterId());
        questDocument.append("attack", monster.getAttack());
        questDocument.append("lifepointAmount", monster.getLifepointAmount());
        questDocument.append("challengeRating", monster.getChallengeRating());
        questDocument.append("monsterName", monster.getMonsterName());
        questDocument.append("monsterLoot", MonsterLootDocumentCreator.getMonsterLootDocument(
                MongoMonsterLoot.getMongoMonsterLootFromMonsterLoot(monsterLoot)));
        questDocument.append("possibleAlliedMonsters", possibleAlliedMonsters);
        return questDocument;
    }

    public static ArrayList<MongoMonster> getMonstersFromDocument(ArrayList<Document> documents)
    {
        ArrayList<MongoMonster> mongoMonsters = new ArrayList<>();
        for (Document document : documents)
        {
            mongoMonsters.add(getMonsterFromDocument(document));
        }
        return mongoMonsters;
    }

    public static MongoMonster getMonsterFromDocument(Document document)
    {
        MongoMonsterLoot monsterLoot = MonsterLootDocumentCreator.getMonsterLootFromDocument(document);

        return new MongoMonster(document.getInteger("_id"), document.getString("monsterName"), document.getInteger("attack"),
                document.getInteger("lifepointAmount"), document.getInteger("challengeRating"), monsterLoot,
                (ArrayList<Integer>) document.get("possibleAlliedMonsters"));
    }
}
