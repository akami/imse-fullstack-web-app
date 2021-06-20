package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkinReport;
import org.bson.Document;

public class MongoSkinReportDocumentCreator
{
    public static MongoSkinReport getMongoSkinReportsFromDocument(Document document)
    {
        return new MongoSkinReport(document.getInteger("_id"), document.getInteger("skin"));
    }
}
