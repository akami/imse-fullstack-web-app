package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.sharedDataModels.Pet;
import org.bson.Document;

import java.util.ArrayList;

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

    public static ArrayList<Document> createPetDocuments(ArrayList<Pet> boughtPets)
    {
        ArrayList<Document> petDocuments = new ArrayList<>();
        for (Pet pet : boughtPets)
        {
            petDocuments.add(createPetDocument(pet));
        }
        return petDocuments;
    }

    public static ArrayList<Pet> getPetsFromDocuments(ArrayList<Document> documents)
    {
        ArrayList<Pet> pets = new ArrayList<>();

        for (Document document : documents)
        {
            pets.add(getPetFromDocument(document));
        }
        return pets;
    }

    public static Pet getPetFromDocument(Document document)
    {
        return new Pet(document.getInteger("_id"), document.getString("petName"), document.getInteger("goldPrice"));
    }
}
