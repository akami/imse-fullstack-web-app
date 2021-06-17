package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import org.bson.Document;

import java.util.ArrayList;

public class GoldOfferDocumentCreator
{
    public static final String GOLDOFFER_COLLECTION_NAME = "goldoffer";

    public static Document createGoldOfferDocument(MongoGoldOffer mongoGoldOffer)
    {
        Document goldOfferDocument = new Document();
        goldOfferDocument.append("accepted", mongoGoldOffer.isAccepted());
        goldOfferDocument.append("successful", mongoGoldOffer.isSuccessful());
        goldOfferDocument.append("goldAmount", mongoGoldOffer.getGoldAmount());
        return goldOfferDocument;
    }

    public static ArrayList<Document> createGoldOfferDocuments(ArrayList<MongoGoldOffer> goldOffers)
    {
        ArrayList<Document> documents = new ArrayList<>();
        for (MongoGoldOffer goldOffer : goldOffers){
            documents.add(createGoldOfferDocument(goldOffer));
        }
        return documents;
    }
}
