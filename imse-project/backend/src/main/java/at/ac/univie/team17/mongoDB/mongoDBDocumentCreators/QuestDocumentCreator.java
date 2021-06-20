package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
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

    public static ArrayList<MongoQuest> getQuestsFromDocument(ArrayList<Document> documents)
    {
        ArrayList<MongoQuest> quests = new ArrayList<>();
        for (Document document : documents)
        {
            quests.add(getQuestFromDocument(document));
        }
        return quests;
    }

    public static MongoQuest getQuestFromDocument(Document document)
    {
        MongoQuestReward mongoQuestReward = QuestRewardDocumentCreator.getQuestRewardFromDocument(
                (Document) document.get("questReward"));

        return new MongoQuest(document.getInteger("_id"), document.getString("questName"),
                document.getString("clientName"), mongoQuestReward);
    }

    public static MongoQuest getMongoQuestWithQuestRewardFromDocument(Document document)
    {
        MongoQuestReward mongoQuestReward = QuestRewardDocumentCreator.getQuestRewardFromDocument(
                (Document) document.get("questReward"));

        return new MongoQuest(document.getInteger("_id"), "", "", mongoQuestReward);
    }

    public static Document createQuestDocument(MongoQuest mongoQuest)
    {
        Document questDocument = new Document();
        questDocument.append("_id", mongoQuest.getQuestId());
        questDocument.append("questName", mongoQuest.getQuestName());
        questDocument.append("clientName", mongoQuest.getClientName());
        questDocument.append("questReward", mongoQuest.getQuestReward());
        return questDocument;
    }
}
