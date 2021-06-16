package at.ac.univie.team17;

import at.ac.univie.team17.mariaDB.MariaDBQueryExecuter;
import at.ac.univie.team17.mariaDB.MariaDBResultReader;
import at.ac.univie.team17.mariaDB.mariaDBQueries.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.GameCharacter;
import at.ac.univie.team17.mongoDB.MongoDBExecuter;
import at.ac.univie.team17.mongoDB.mongoDBDocumentCreators.*;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClass;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
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

            // get bought pets
            ResultSet rsPets = MariaDBQueryExecuter.executeReturnQuery(
                    statement, PlayerPetQueries.getSelectPlayerPetFromPlayerIdQuery(player.getPlayerId()));
            ArrayList<Pet> boughtPets = MariaDBResultReader.getPetFromResultSet(rsPets);

            // get created characters TODO

            // add to documents TODO

        }
        db.getCollection(PlayerDocumentCreator.PLAYER_COLLECTION_NAME).insertMany(playerDocuments);
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
        ArrayList<Document> gameCharacterDocuments = new ArrayList<>();

        ArrayList<GameCharacter> gameCharacters = MariaDBResultReader.getGameCharactersFromResultSet(rs);
        for (GameCharacter gameCharacter : gameCharacters)
        {
            // get skins
            ResultSet rsSkins = MariaDBQueryExecuter.executeReturnQuery(
                    statement, CharacterSkinQueries.getSelectCharacterSkinsFromCharacterIdQuery(gameCharacter.getCharacterId()));
            ArrayList<Skin> boughtSkins = MariaDBResultReader.getSkinsFromResultSet(rsSkins);

            // get class
            ResultSet rsCharacterClass = MariaDBQueryExecuter.executeReturnQuery(
                    statement, CharacterSkinQueries.getSelectCharacterSkinsFromCharacterIdQuery(gameCharacter.getCharacterId()));
            CharacterClass characterClass = MariaDBResultReader.getCharacterClassFromResultSet(rsCharacterClass);
            // get class skins
            ResultSet rsClassSkins = MariaDBQueryExecuter.executeReturnQuery(
                    statement, SkinQueries.getSelectSkinsFromClassIdQuery(characterClass.getClassId()));
            ArrayList<Skin> classSkins = MariaDBResultReader.getSkinsFromResultSet(rsClassSkins);
            ArrayList<MongoSkin> mongoClassSkins = MongoSkin.getMongoSkinsFromSkin(classSkins);

            MongoCharacterClass mongoCharacterClass = new MongoCharacterClass(characterClass.getClassId(), characterClass.getBonusAttack(),
                    characterClass.getBonusLifepoints(), characterClass.getClassName(), mongoClassSkins);

            // get player age TODO


            // get quests TODO


            // get slayed monsters TODO


            gameCharacterDocuments.add(CharacterDocumentCreator.createCharacterDocument(gameCharacter, classSkins));
        }

        MongoDBExecuter.insertDocuments(db, gameCharacterDocuments, CharacterDocumentCreator.CHARACTER_COLLECTION_NAME);
    }

    private static void migrateCharacterClassData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, CharacterClassQueries.getSelectAllCharacterClassesQuery());
        ArrayList<Document> characterClassDocuments = new ArrayList<>();

        ArrayList<CharacterClass> characterClasses = MariaDBResultReader.getCharacterClassesFromResultSet(rs);
        for (CharacterClass characterClass : characterClasses)
        {
            // get skins
            ResultSet rsSkins = MariaDBQueryExecuter.executeReturnQuery(
                    statement, SkinQueries.getSelectSkinsFromClassIdQuery(characterClass.getClassId()));
            ArrayList<Skin> classSkins = MariaDBResultReader.getSkinsFromResultSet(rsSkins);

            characterClassDocuments.add(CharacterClassDocumentCreator.createCharacterClassDocument(characterClass, classSkins));
        }

        MongoDBExecuter.insertDocuments(db, characterClassDocuments, CharacterClassDocumentCreator.CHARACTER_CLASS_COLLECTION_NAME);
    }

    private static void migrateQuestData(Statement statement, MongoDatabase db)
    {
        ResultSet rs = MariaDBQueryExecuter.executeReturnQuery(statement, QuestQueries.getSelectAllQuestsQuery());
        ArrayList<Document> questDocuments = new ArrayList<>();

        ArrayList<Quest> quests = MariaDBResultReader.getQuestsFromResultSet(rs);
        for (Quest quest : quests)
        {
            // get quest reward
            ResultSet rsQuestReward = MariaDBQueryExecuter.executeReturnQuery(
                    statement, QuestRewardQueries.getSelectQuestRewardFromIdQuery(quest.getQuestRewardId()));
            QuestReward questReward = MariaDBResultReader.getQuestRewardFromResultSet(rsQuestReward);

            questDocuments.add(QuestDocumentCreator.createQuestDocument(quest, questReward));
        }

        MongoDBExecuter.insertDocuments(db, questDocuments, QuestDocumentCreator.QUEST_COLLECTION_NAME);
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
            ArrayList<Integer> alliedMonsters = MariaDBResultReader.getAlliedMonsterIDsFromResultSet(rsAlliedMonsters);

            monsterDocuments.add(MonsterDocumentCreator.createMonsterDocument(monster, monsterLoot, alliedMonsters));
        }

        MongoDBExecuter.insertDocuments(db, monsterDocuments, MonsterDocumentCreator.MONSTER_COLLECTION_NAME);
    }
}
