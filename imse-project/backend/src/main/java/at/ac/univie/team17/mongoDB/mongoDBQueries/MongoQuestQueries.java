package at.ac.univie.team17.mongoDB.mongoDBQueries;

import at.ac.univie.team17.MongoDBConnectionHandler;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.QuestDocumentCreator;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuestRewardWithIds;
import com.mongodb.Block;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoQuestQueries
{

    public static List<MongoQuest> getMongoQuests()
    {
        List<MongoQuest> mongoQuests = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(QuestDocumentCreator.QUEST_COLLECTION_NAME)
                .find().forEach((Block<Document>) document ->
                mongoQuests.add(QuestDocumentCreator.getQuestFromDocument(document)));

        MongoDBConnectionHandler.closeConnection();
        return mongoQuests;
    }

    public static List<MongoQuestRewardWithIds> getMongoQuestRewardsWithIds()
    {
        List<MongoQuestRewardWithIds> mongoQuestRewards = new ArrayList<>();

        MongoDBConnectionHandler.setupConnection();

        MongoDBConnectionHandler.getDb().getCollection(QuestDocumentCreator.QUEST_COLLECTION_NAME).find().
                projection(Projections.include("_id", "questReward")).forEach((Block<Document>) document ->
                {
                    MongoQuest mongoQuest = QuestDocumentCreator.getMongoQuestWithQuestRewardFromDocument(document);
                    mongoQuestRewards.add(new MongoQuestRewardWithIds(mongoQuest.getQuestId(), mongoQuest.getQuestReward()));
                });

        MongoDBConnectionHandler.closeConnection();
        return mongoQuestRewards;
    }
}
