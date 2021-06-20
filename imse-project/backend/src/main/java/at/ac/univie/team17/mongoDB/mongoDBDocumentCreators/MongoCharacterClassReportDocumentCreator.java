package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClassReport;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkinReport;
import org.bson.Document;

public class MongoCharacterClassReportDocumentCreator
{
    public static MongoCharacterClassReport getMongoCharacterClassReportFromDocument(Document document)
    {
        return new MongoCharacterClassReport(document.getInteger("_id"), document.getInteger("counter"));
    }
}
