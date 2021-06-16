package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.sharedDataModels.Pet;
import org.bson.Document;

public class PetDocumentCreator
{
    public static final String PET_COLLECTION_NAME = "pet";

    public static Document createPetDocument(Pet pet)
    {
        Document petDocument = new Document();
        petDocument.append("_id", pet.getPetId());
        petDocument.append("petName", pet.getPetName());
        petDocument.append("goldPrice", pet.getGoldPrice());
        return petDocument;
    }
}
