package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
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
        questDocument.append("monsterLoot", monsterLoot);
        questDocument.append("possibleAlliedMonsters", possibleAlliedMonsters);
        return questDocument;
    }
}
