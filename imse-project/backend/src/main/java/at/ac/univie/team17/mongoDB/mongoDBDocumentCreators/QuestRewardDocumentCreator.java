package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuestReward;
import org.bson.Document;

public class QuestRewardDocumentCreator
{

    public static Document getQuestRewardDocument(MongoQuestReward questReward)
    {
        Document questRewardDocument = new Document();
        questRewardDocument.append("goldAmount", questReward.getGoldAmount());
        questRewardDocument.append("experienceAmount", questReward.getExperienceAmount());
        return questRewardDocument;
    }

    public static MongoQuestReward getQuestRewardFromDocument(Document document)
    {
        return new MongoQuestReward(document.getInteger("goldAmount"), document.getInteger("experienceAmount"));
    }
}
