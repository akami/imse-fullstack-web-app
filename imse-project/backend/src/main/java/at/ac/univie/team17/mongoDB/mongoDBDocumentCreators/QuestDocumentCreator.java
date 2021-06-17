package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuestReward;
import org.bson.Document;

import java.util.ArrayList;

public class QuestDocumentCreator
{
    public static final String QUEST_COLLECTION_NAME = "quest";

    public static Document createQuestDocument(Quest quest, MongoQuestReward questReward)
    {
        Document questDocument = new Document();
        questDocument.append("_id", quest.getQuestId());
        questDocument.append("questName", quest.getQuestName());
        questDocument.append("clientName", quest.getClientName());
        questDocument.append("questReward", QuestRewardDocumentCreator.getQuestRewardDocument(questReward));
        return questDocument;
    }

    public static ArrayList<Document> createQuestDocuments(ArrayList<Quest> completedQuests,
                                                           ArrayList<MongoQuestReward> mongoQuestRewardFromQuests)
    {
        ArrayList<Document> questDocuments = new ArrayList<>();
        for (int i = 0; i < completedQuests.size(); ++i)
        {
            questDocuments.add(createQuestDocument(completedQuests.get(i), mongoQuestRewardFromQuests.get(i)));
        }
        return questDocuments;
    }
}
