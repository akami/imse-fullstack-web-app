package at.ac.univie.team17.mongoDB.mongoDBDocumentCreators;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.*;
import org.bson.Document;

import javax.print.Doc;
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

    public static ArrayList<MongoCharacter> getCharactersFromDocuments(ArrayList<Document> documents)
    {
        ArrayList<MongoCharacter> mongoCharacters = new ArrayList<>();
        for (Document document : documents)
        {
            mongoCharacters.add(getCharacterFromDocument(document));
        }
        return mongoCharacters;
    }

    public static MongoCharacter getCharacterFromDocument(Document document)
    {
        ArrayList<MongoQuest> completedQuests = QuestDocumentCreator.getQuestsFromDocument(
                (ArrayList<Document>) document.get("completedQuests"));
        ArrayList<MongoSkin> boughtSkins = SkinDocumentCreator.getSkinsFromDocument(
                (ArrayList<Document>) document.get("boughtSkins"));
        ArrayList<SlayedMonsters> slayedMonsters = SlayedMonsterDocumentCreator.getSlayedMonstersFromDocument(
                (ArrayList<Document>) document.get("slayedMonsters"));
        PlayerAge playerAge = PlayerAgeDocumentCreator.getPlayerAgeFromDocument((Document)document.get("playerAge"));
        MongoCharacterClass characterClass = CharacterClassDocumentCreator.getCharacterClassFromDocument((Document)document.get("characterClass"));

        return new MongoCharacter(document.getInteger("_id"), document.getString("characterName"), document.getInteger("attack"),
                document.getInteger("lifepointAmount"), characterClass, boughtSkins, completedQuests, slayedMonsters, playerAge);
    }

    public static MongoCharacter getMongoCharacterFromCharacter(GameCharacter gameCharacter)
    {
        return new MongoCharacter(gameCharacter.getCharacterId(), gameCharacter.getCharacterName(), gameCharacter.getAttack(),
                gameCharacter.getLifepointAmount(), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);
    }
}
