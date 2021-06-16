package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import org.bson.Document;

public class QuestDocumentCreator
{
    public static final String QUEST_COLLECTION_NAME = "quest";

    public static Document createQuestDocument(Quest quest, QuestReward questReward)
    {
        Document questDocument = new Document();
        questDocument.append("_id", quest.getQuestId());
        questDocument.append("questName", quest.getQuestName());
        questDocument.append("clientName", quest.getClientName());
        questDocument.append("questReward", questReward);
        return questDocument;
    }
}
