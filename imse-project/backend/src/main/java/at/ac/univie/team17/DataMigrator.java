package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.MongoDBExecuter;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.*;
import at.ac.univie.team17.mongoDB.mongoDBmodels.*;
import at.ac.univie.team17.sharedDataModels.Pet;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataMigrator
{
    public static void migrateData(Statement statement, MongoDatabase db)
    {
        migratePetData(statement, db);
        migratePlayerData(statement, db);
        migrateCharacterData(statement, db);
        migrateCharacterClassData(statement, db);
        migrateQuestData(statement, db);
        migrateMonsterData(statement, db);
    }

    private static void migratePlayerData(Statement statement, MongoDatabase db)
    {
        // get all players
        ResultSet rsPlayer = MariaDBQueryExecuter.executeReturnQuery(statement, PlayerQueries.getSelectAllPlayersQuery());
        ArrayList<Player> players = MariaDBResultReader.getPlayersFromResultSet(rsPlayer);

        ArrayList<Document> playerDocuments = new ArrayList<>();
        for (Player player : players) {
            // get gold offers
            ResultSet rsGoldOffer = MariaDBQueryExecuter.executeReturnQuery(
                    statement, GoldOfferQueries.getSelectedGoldOffersFromPlayerIdQuery(player.getPlayerId()));
            ArrayList<GoldOffer> goldOffers = MariaDBResultReader.getGoldOffersFromResultSet(rsGoldOffer);
            ArrayList<MongoGoldOffer> mongoGoldOffers = MongoGoldOffer.getMongoGoldOffersFromGoldOffers(goldOffers);

            // get bought pets
            ResultSet rsPets = MariaDBQueryExecuter.executeReturnQuery(
                    statement, PlayerPetQueries.getSelectPlayerPetFromPlayerIdQuery(player.getPlayerId()));
            ArrayList<Pet> boughtPets = MariaDBResultReader.getPetFromResultSet(rsPets);
            ArrayList<Document> boughtPetDocuments = PetDocumentCreator.createPetDocuments(boughtPets);

            // get created characters
            ResultSet rsCharacters = MariaDBQueryExecuter.executeReturnQuery(
                    statement, CharacterQueries.getSelectCharacterFromPlayerIdQuery(player.getPlayerId()));
            ArrayList<GameCharacter> createdCharacters = MariaDBResultReader.getGameCharactersFromResultSet(rsCharacters);
            ArrayList<Integer> mongoCharacterIds = new ArrayList<>();

            for (GameCharacter gameCharacter : createdCharacters)
            {
                mongoCharacterIds.add(gameCharacter.getCharacterId());
            }

            // add to documents
            playerDocuments.add(PlayerDocumentCreator.createPlayerDocument(player, mongoGoldOffers, boughtPetDocuments, mongoCharacterIds));
        }
        db.getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME).insertMany(playerDocuments);
    }

    private static Document getMongoCharacterDocument(MongoCharacter mongoCharacter, Statement statement, ArrayList<Quest> completedQuests)
    {
        return CharacterDocumentCreator.createCharacterDocument(mongoCharacter,
                SkinDocumentCreator.getSkinDocuments(mongoCharacter.getBoughtSkins()),
                SlayedMonsterDocumentCreator.getSlayedMonsterDocuments(mongoCharacter.getSlayedMonsters()),
                QuestDocumentCreator.createQuestDocuments(completedQuests,
                        getMongoQuestRewardFromQuests(statement, completedQuests)),
                PlayerAgeDocumentCreator.getPlayerAgeDocument(mongoCharacter.getPlayerAge()),
                CharacterClassDocumentCreator.createCharacterClassDocument(mongoCharacter.getCharacterClass(),
                        getSkinsFromCharacterClass(statement, mongoCharacter.getCharacterClass().getClassId())));
    }

    private static void migratePetData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, PetQueries.getSelectAllPetsQuery());
        ArrayList<Document> petDocuments = new ArrayList<>();

        ArrayList<Pet> pets = MariaDBResultReader.getPetFromResultSet(rs);
        for (Pet pet : pets)
        {
            petDocuments.add(PetDocumentCreator.createPetDocument(pet));
        }

        MongoDBExecuter.insertDocuments(db, petDocuments, PetDocumentCreator.PET_COLLECTION_NAME);
    }

    private static void migrateCharacterData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, CharacterQueries.getSelectAllCharactersQuery());
        ArrayList<Document> mongoCharacterDocuments = new ArrayList<>();

        ArrayList<GameCharacter> gameCharacters = MariaDBResultReader.getGameCharactersFromResultSet(rs);
        for (GameCharacter gameCharacter : gameCharacters)
        {
            ResultSet rsCompletedQuests = MariaDBQueryExecuter.executeReturnQuery(
                    statement, CharacterQuestQueries.getSelectCompletedQuestsFromCharacterIdQuery(gameCharacter.getCharacterId()));
            ArrayList<Quest> completedQuests = MariaDBResultReader.getQuestsFromResultSet(rsCompletedQuests);

            MongoCharacter mongoCharacter = getMongoCharacterFromGameCharacter(gameCharacter, statement);

            mongoCharacterDocuments.add(getMongoCharacterDocument(mongoCharacter, statement, completedQuests));
        }

        MongoDBExecuter.insertDocuments(db, mongoCharacterDocuments, CharacterDocumentCreator.CHARACTER_COLLECTION_NAME);
    }

    private static MongoCharacter getMongoCharacterFromGameCharacter(GameCharacter gameCharacter, Statement statement)
    {
        // get skins
        ResultSet rsSkins = MariaDBQueryExecuter.executeReturnQuery(
                statement, CharacterSkinQueries.getSelectCharacterSkinsFromCharacterIdQuery(gameCharacter.getCharacterId()));
        ArrayList<Skin> boughtSkins = MariaDBResultReader.getSkinsFromResultSet(rsSkins);
        ArrayList<MongoSkin> mongoBoughtSkins = MongoSkin.getMongoSkinsFromSkin(boughtSkins);

        // get class
        ResultSet rsCharacterClass = MariaDBQueryExecuter.executeReturnQuery(
                statement, CharacterQueries.getSelectCharacterClassFromCharacterId(gameCharacter.getCharacterId()));
        CharacterClass characterClass = MariaDBResultReader.getCharacterClassFromResultSet(rsCharacterClass);
        // get class skins
        ResultSet rsClassSkins = MariaDBQueryExecuter.executeReturnQuery(
                statement, SkinQueries.getSelectSkinsFromClassIdQuery(characterClass.getClassId()));
        ArrayList<Skin> classSkins = MariaDBResultReader.getSkinsFromResultSet(rsClassSkins);
        ArrayList<MongoSkin> mongoClassSkins = MongoSkin.getMongoSkinsFromSkin(classSkins);

        MongoCharacterClass mongoCharacterClass = new MongoCharacterClass(characterClass.getClassId(), characterClass.getBonusAttack(),
                characterClass.getBonusLifepoints(), characterClass.getClassName(), mongoClassSkins);

        // get player age
        ResultSet rsPlayer = MariaDBQueryExecuter.executeReturnQuery(
                statement, PlayerQueries.getSelectPlayerFromIdQuery(gameCharacter.getPlayerId()));
        Player player = MariaDBResultReader.getPlayerFromResultSet(rsPlayer);
        PlayerAge playerAge = new PlayerAge(player.getPlayerId(), player.getAge());

        // get quests
        ResultSet rsCompletedQuests = MariaDBQueryExecuter.executeReturnQuery(
                statement, CharacterQuestQueries.getSelectCompletedQuestsFromCharacterIdQuery(gameCharacter.getCharacterId()));
        ArrayList<Quest> completedQuests = MariaDBResultReader.getQuestsFromResultSet(rsCompletedQuests);
        ArrayList<MongoQuest> mongoCompletedQuests = MongoQuest.getMongoQuestsFromQuest(completedQuests, statement);

        // get slayed monsters
        ResultSet rsSlayedMonsters = MariaDBQueryExecuter.executeReturnQuery(
                statement, CharacterMonsterQueries.getSelectSlayedMonstersFromCharacterIdQuery(gameCharacter.getCharacterId()));
        ArrayList<SlayedMonsters> slayedMonsters = MariaDBResultReader.getSlayedMonstersFromResultSet(rsSlayedMonsters);

        return new MongoCharacter(gameCharacter.getCharacterId(), gameCharacter.getCharacterName(), gameCharacter.getAttack(),
                gameCharacter.getLifepointAmount(), mongoCharacterClass, mongoBoughtSkins, mongoCompletedQuests,
                slayedMonsters, playerAge);
    }

    private static void migrateCharacterClassData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, CharacterClassQueries.getSelectAllCharacterClassesQuery());
        ArrayList<Document> characterClassDocuments = new ArrayList<>();

        ArrayList<CharacterClass> characterClasses = MariaDBResultReader.getCharacterClassesFromResultSet(rs);
        for (CharacterClass characterClass : characterClasses)
        {
            characterClassDocuments.add(CharacterClassDocumentCreator.createCharacterClassDocument(characterClass,
                    getSkinsFromCharacterClass(statement, characterClass.getClassId())));
        }

        MongoDBExecuter.insertDocuments(db, characterClassDocuments, CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME);
    }

    private static ArrayList<Skin> getSkinsFromCharacterClass(Statement statement, int characterClassId)
    {
        // get skins
        ResultSet rsSkins = MariaDBQueryExecuter.executeReturnQuery(
                statement, SkinQueries.getSelectSkinsFromClassIdQuery(characterClassId));
        return MariaDBResultReader.getSkinsFromResultSet(rsSkins);
    }

    private static void migrateQuestData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, QuestQueries.getSelectAllQuestsQuery());
        ArrayList<Document> questDocuments = new ArrayList<>();

        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(rs);

        for (Quest quest : quests)
        {
            questDocuments.add(QuestDocumentCreator.createQuestDocument(quest, getMongoQuestRewardFromQuest(statement, quest)));
        }

        MongoDBExecuter.insertDocuments(db, questDocuments, QuestDocumentCreator.QUEST_COLLECTION_NAME);
    }

    private static ArrayList<MongoQuestReward> getMongoQuestRewardFromQuests(Statement statement, ArrayList<Quest> quests )
    {
        ArrayList<MongoQuestReward> mongoQuestRewards = new ArrayList<>();
        for (Quest quest : quests)
        {
            mongoQuestRewards.add(getMongoQuestRewardFromQuest(statement, quest));
        }
        return mongoQuestRewards;
    }

    private static MongoQuestReward getMongoQuestRewardFromQuest(Statement statement, Quest quest)
    {
        ResultSet rsQuestReward = MariaDBQueryExecuter.executeReturnQuery(
                statement, QuestRewardQueries.getSelectQuestRewardFromIdQuery(quest.getQuestRewardId()));
        QuestReward questReward = MariaDBResultReader.getQuestRewardFromResultSet(rsQuestReward);
        return MongoQuestReward.getMongoQuestRewardFromQuestReward(questReward);
    }

    private static void migrateMonsterData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, MonsterQueries.getSelectAllMonstersQuery());
        ArrayList<Document> monsterDocuments = new ArrayList<>();

        ArrayList<Monster> monsters = MariaDBResultReader.getMonstersFromResultSet(rs);
        for (Monster monster : monsters)
        {
            // get monster loot
            ResultSet rsMonsterLoot = MariaDBQueryExecuter.executeReturnQuery(
                    statement, MonsterLootQueries.getSelectMonsterLootFromIdQuery(monster.getMonsterLootId()));
            MonsterLoot monsterLoot = MariaDBResultReader.getMonsterLootFromResultSet(rsMonsterLoot);

            // get possible allied monster ids
            ResultSet rsAlliedMonsters = MariaDBQueryExecuter.executeReturnQuery(
                    statement, AlliedMonstersQueries.getSelectAlliedMonsterIdsFromIdQuery(monster.getMonsterId()));

            ArrayList<Integer> alliedMonsters = new ArrayList<>();
            if (rsAlliedMonsters!= null)
            {
                alliedMonsters = MariaDBResultReader.getAlliedMonsterIDsFromResultSet(rsAlliedMonsters);
            }

            monsterDocuments.add(MonsterDocumentCreator.createMonsterDocument(monster, monsterLoot, alliedMonsters));
        }

        MongoDBExecuter.insertDocuments(db, monsterDocuments, MonsterDocumentCreator.MONSTER_COLLECTION_NAME);
    }
}
