package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.bson.Document;

import java.util.ArrayList;

public class PlayerDocumentCreator
{
    public static final String PLAYER_COLLECTION_NAME = "player";

    public static Document createPlayerDocument(Player player, ArrayList<MongoGoldOffer> goldOffers, ArrayList<Document> boughtPets,
                                                ArrayList<Integer> characters)
    {
        Document playerDocument = new Document();
        playerDocument.append("_id", player.getPlayerId());
        playerDocument.append("username", player.getUsername());
        playerDocument.append("age", player.getAge());
        playerDocument.append("emailAddress", player.getEmailAddress());
        playerDocument.append("goldOffers", GoldOfferDocumentCreator.createGoldOfferDocuments(goldOffers));
        playerDocument.append("boughtPets", boughtPets);
        playerDocument.append("characters", characters);
        return playerDocument;
    }

    public static MongoPlayer getMongoPlayerFromDocument(Document document)
    {
        ArrayList<MongoGoldOffer> goldOffers = GoldOfferDocumentCreator.getGoldOffersFromDocument(
                (ArrayList<Document>) document.get("goldOffers"));
        ArrayList<Pet> boughtPets = PetDocumentCreator.getPetsFromDocuments((ArrayList<Document>) document.get("boughtPets"));
        ArrayList<Integer> createdCharacters = (ArrayList<Integer>)document.get("characters");

        return new MongoPlayer(document.getInteger("_id"), document.getString("username"), document.getInteger("age"),
                document.getString("emailAddress"), boughtPets, createdCharacters, goldOffers);
    }

    public static MongoPlayer getMongoPlayerWithCharactersFromDocument(Document document)
    {
        ArrayList<Integer> createdCharacters = (ArrayList<Integer>)document.get("characters");

        return new MongoPlayer(0, "", 0,"", new ArrayList<>(), createdCharacters, new ArrayList<>());
    }

    public static MongoPlayer getMongoPlayerWithGoldOffersFromDocument(Document document)
    {
        ArrayList<MongoGoldOffer> goldOffers = GoldOfferDocumentCreator.getGoldOffersFromDocument(
                (ArrayList<Document>)document.get("goldOffers"));

        return new MongoPlayer(0, "", 0,"", new ArrayList<>(), new ArrayList<>(), goldOffers);
    }

    public static MongoPlayer getMongoPlayerWithPetsFromDocument(Document document)
    {
        ArrayList<Pet> pets = PetDocumentCreator.getPetsFromDocuments((ArrayList<Document>)document.get("boughtPets"));

        return new MongoPlayer(0, "", 0,"", pets, new ArrayList<>(), new ArrayList<>());
    }
}
