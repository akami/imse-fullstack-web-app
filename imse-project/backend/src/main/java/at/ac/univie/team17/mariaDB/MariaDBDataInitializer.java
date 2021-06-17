package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.*;
import at.ac.univie.team17.mariaDB.mariaDBmodelData.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.sharedDataModels.Pet;

import java.sql.Statement;
import java.util.ArrayList;

public class MariaDBDataInitializer
{
    private static String insertQuery;
    public static void initializeMariaDBData(Statement statement)
    {
        ArrayList<Player> players = PlayerData.getPlayerData();
        insertPlayersInMariaDB(statement, players);

        ArrayList<CharacterClass> characterClasses = CharacterClassData.getCharacterClassData();
        insertCharacterClassesInMariaDB(statement, characterClasses);

        ArrayList<Pet> pets = PetData.getPetData();
        insertPetsInMariaDB(statement, pets);

        ArrayList<PlayerPet> playerPets = PlayerPetDataGenerator.generatePlayerPetsData(5, players.size(), pets.size());
        insertPlayerPetsInMariaDB(statement, playerPets);

        ArrayList<GoldOffer> goldOffers = GoldOfferDataGenerator.generateGoldOfferData(20, players.size());
        insertGoldOffersInMariaDB(statement, goldOffers);

        ArrayList<GameCharacter> gameCharacters = CharacterDataGenerator.generateCharacterData(30, players.size(), characterClasses.size());
        insertCharactersInMariaDB(statement, gameCharacters);

        ArrayList<MonsterLoot> monsterLoots = MonsterLootDataGenerator.generateMonsterLootData(120);
        insertMonsterLootsInMariaDB(statement, monsterLoots);

        ArrayList<Monster> monsters = MonsterDataGenerator.generateMonsterData(20);
        insertMonstersInMariaDB(statement, monsters);

        ArrayList<AlliedMonsters> alliedMonsters = AlliedMonstersDataGenerator.generateAlliedMonstersData(20, monsters.size());
        insertAlliedMonstersInMariaDB(statement, alliedMonsters);

        ArrayList<QuestReward> questRewards = QuestRewardDataGenerator.generateQuestRewardData(20);
        insertQuestRewardsInMariaDB(statement, questRewards);

        ArrayList<Quest> quests = QuestDataGenerator.generateQuestData(20);
        insertQuestsInMariaDB(statement, quests);

        ArrayList<Skin> skins = SkinData.getSkinData();
        insertSkinsInMariaDB(statement, skins);

        ArrayList<CharacterSkin> characterSkins = CharacterSkinDataGenerator.generateCharacterSkinsData(
                0, gameCharacters.size(), skins.size());
        insertCharacterSkinsInMariaDB(statement, characterSkins);

        ArrayList<CharacterQuest> characterQuests = CharacterQuestDataGenerator.generateCharacterQuestData(
                5, gameCharacters.size(), quests.size());
        insertCharacterQuestsInMariaDB(statement, characterQuests);
    }

    private static void insertPlayersInMariaDB(Statement statement, ArrayList<Player> players)
    {
        for (Player player : players)
        {
            insertQuery = PlayerQueries.getInsertPlayersQuery(player);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterClassesInMariaDB(Statement statement, ArrayList<CharacterClass> characterClasses)
    {
        for (CharacterClass characterClass : characterClasses)
        {
            insertQuery = CharacterClassQueries.getInsertCharacterClassQuery(characterClass);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertPetsInMariaDB(Statement statement, ArrayList<Pet> pets)
    {
        for (Pet pet : pets)
        {
            insertQuery = PetQueries.getInsertPetQuery(pet);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertPlayerPetsInMariaDB(Statement statement, ArrayList<PlayerPet> playerPets)
    {
        for (PlayerPet playerPet : playerPets)
        {
            insertQuery = PlayerPetQueries.getInsertPlayerPetQuery(playerPet);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertGoldOffersInMariaDB(Statement statement, ArrayList<GoldOffer> goldOffers)
    {
        for (GoldOffer goldOffer : goldOffers)
        {
            insertQuery = GoldOfferQueries.getInsertGoldOfferQuery(goldOffer);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertCharactersInMariaDB(Statement statement, ArrayList<GameCharacter> gameCharacters)
    {
        for (GameCharacter gameCharacter : gameCharacters)
        {
            insertQuery = CharacterQueries.getInsertCharacterQuery(gameCharacter);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertMonsterLootsInMariaDB(Statement statement, ArrayList<MonsterLoot> monsterLoots)
    {
        for (MonsterLoot monsterLoot : monsterLoots)
        {
            insertQuery = MonsterLootQueries.getInsertMonsterLootQuery(monsterLoot);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertMonstersInMariaDB(Statement statement, ArrayList<Monster> monsters)
    {
        for (Monster monster : monsters)
        {
            insertQuery = MonsterQueries.getInsertMonsterQuery(monster);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertAlliedMonstersInMariaDB(Statement statement, ArrayList<AlliedMonsters> alliedMonsters)
    {
        for (AlliedMonsters monster : alliedMonsters)
        {
            insertQuery = AlliedMonstersQueries.getInsertAlliedMonsterQuery(monster);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertQuestRewardsInMariaDB(Statement statement, ArrayList<QuestReward> questRewards)
    {
        for (QuestReward questReward : questRewards)
        {
            insertQuery = QuestRewardQueries.getInsertQuestRewardQuery(questReward);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertQuestsInMariaDB(Statement statement, ArrayList<Quest> quests)
    {
        for (Quest quest : quests)
        {
            insertQuery = QuestQueries.getInsertQuestQuery(quest);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertSkinsInMariaDB(Statement statement, ArrayList<Skin> skins)
    {
        for (Skin skin : skins)
        {
            insertQuery = SkinQueries.getInsertSkinQuery(skin);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterSkinsInMariaDB(Statement statement, ArrayList<CharacterSkin> characterSkins)
    {
        for (CharacterSkin characterSkin : characterSkins)
        {
            insertQuery = CharacterSkinQueries.getInsertCharacterSkinQuery(characterSkin);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterQuestsInMariaDB(Statement statement, ArrayList<CharacterQuest> characterQuests)
    {
        for (CharacterQuest characterQuest : characterQuests)
        {
            insertQuery = CharacterQuestQueries.getInsertCharacterQuestQuery(characterQuest);
            MariaDBQueryExecuter.executeNoReturnQuery(statement, insertQuery);
        }
    }
}
