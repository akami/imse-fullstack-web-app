package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.*;
import com.mongodb.Mongo;
import org.bson.Document;

import java.util.ArrayList;

public class CharacterDocumentCreator
{
    public static final String CHARACTER_COLLECTION_NAME = "gameCharacter";

    public static Document createCharacterDocument(MongoCharacter mongoCharacter, ArrayList<Document> boughtSkins,
                                                   ArrayList<Document> slayedMonsters, ArrayList<Document> completedQuests,
                                                   Document playerAge, Document characterClass)
    {
        Document characterDocument = new Document();
        characterDocument.append("_id", mongoCharacter.getCharacterId());
        characterDocument.append("characterName", mongoCharacter.getCharacterName());
        characterDocument.append("attack", mongoCharacter.getAttack());
        characterDocument.append("lifepointAmount", mongoCharacter.getLifepointAmount());
        characterDocument.append("characterClass", characterClass);
        characterDocument.append("boughtSkins", boughtSkins);
        characterDocument.append("completedQuests", completedQuests);
        characterDocument.append("slayedMonsters", slayedMonsters);
        characterDocument.append("playerAge", playerAge);
        return characterDocument;
    }
}
