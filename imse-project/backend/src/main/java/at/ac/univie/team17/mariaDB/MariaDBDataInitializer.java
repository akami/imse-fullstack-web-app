package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.*;
import at.ac.univie.team17.mariaDB.mariaDBmodelData.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.mariaDB.mariaDBmodels.Character;

import java.sql.Statement;
import java.util.ArrayList;

public class MariaDBDataInitializer
{
    private static String insertQuery;
    public static void initializeMariaDBData(Statement statement)
    {
        ArrayList<Player> players = PlayerDataGenerator.generatePlayerData(10);
        insertPlayersInMariaDB(statement, players);

        ArrayList<CharacterClass> characterClasses = CharacterClassData.getCharacterClassData();
        insertCharacterClassesInMariaDB(statement, characterClasses);

        ArrayList<Pet> pets = PetData.getPetData();
        insertPetsInMariaDB(statement, pets);

        ArrayList<PlayerPet> playerPets = PlayerPetDataGenerator.generatePlayerPetsData(20, players.size(), pets.size());
        insertPlayerPetsInMariaDB(statement, playerPets);

        ArrayList<GoldOffer> goldOffers = GoldOfferDataGenerator.generateGoldOfferData(20, players.size());
        insertGoldOffersInMariaDB(statement, goldOffers);

        ArrayList<Character> characters = CharacterDataGenerator.generateCharacterData(30, players.size());
        insertCharactersInMariaDB(statement, characters);

        ArrayList<MonsterLoot> monsterLoots = MonsterLootDataGenerator.generateMonsterLootData(120);
        insertMonsterLootsInMariaDB(statement, monsterLoots);

        ArrayList<Monster> monsters = MonsterDataGenerator.generateMonsterData(120, characters.size());
        insertMonstersInMariaDB(statement, monsters);

        ArrayList<QuestReward> questRewards = QuestRewardDataGenerator.generateQuestRewardData(10);
        insertQuestRewardsInMariaDB(statement, questRewards);

        ArrayList<Quest> quests = QuestDataGenerator.generateQuestData(10);
        insertQuestsInMariaDB(statement, quests);

        ArrayList<Skin> skins = SkinData.getSkinData();
        insertSkinsInMariaDB(statement, skins);

        ArrayList<CharacterSkin> characterSkins = CharacterSkinDataGenerator.generateCharacterSkinsData(
                50, characters.size(), skins.size());
        insertCharacterSkinsInMariaDB(statement, characterSkins);

        ArrayList<CharacterQuest> characterQuests = CharacterQuestDataGenerator.generateCharacterQuestData(
                60, characters.size(), quests.size());
        insertCharacterQuestsInMariaDB(statement, characterQuests);
    }

    private static void insertPlayersInMariaDB(Statement statement, ArrayList<Player> players)
    {
        for (Player player : players)
        {
            insertQuery = PlayerQueries.getInsertPlayersQuery(player);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterClassesInMariaDB(Statement statement, ArrayList<CharacterClass> characterClasses)
    {
        for (CharacterClass characterClass : characterClasses)
        {
            insertQuery = CharacterClassQueries.getInsertCharacterClassQuery(characterClass);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertPetsInMariaDB(Statement statement, ArrayList<Pet> pets)
    {
        for (Pet pet : pets)
        {
            insertQuery = PetQueries.getInsertPetQuery(pet);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertPlayerPetsInMariaDB(Statement statement, ArrayList<PlayerPet> playerPets)
    {
        for (PlayerPet playerPet : playerPets)
        {
            insertQuery = PlayerPetQueries.getInsertPlayerPetQuery(playerPet);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertGoldOffersInMariaDB(Statement statement, ArrayList<GoldOffer> goldOffers)
    {
        for (GoldOffer goldOffer : goldOffers)
        {
            insertQuery = GoldOfferQueries.getInsertGoldOfferQuery(goldOffer);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertCharactersInMariaDB(Statement statement, ArrayList<Character> characters)
    {
        for (Character character : characters)
        {
            insertQuery = CharacterQueries.getInsertCharacterQuery(character);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertMonsterLootsInMariaDB(Statement statement, ArrayList<MonsterLoot> monsterLoots)
    {
        for (MonsterLoot monsterLoot : monsterLoots)
        {
            insertQuery = MonsterLootQueries.getInsertMonsterLootQuery(monsterLoot);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertMonstersInMariaDB(Statement statement, ArrayList<Monster> monsters)
    {
        for (Monster monster : monsters)
        {
            insertQuery = MonsterQueries.getInsertMonsterQuery(monster);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertQuestRewardsInMariaDB(Statement statement, ArrayList<QuestReward> questRewards)
    {
        for (QuestReward questReward : questRewards)
        {
            insertQuery = QuestRewardQueries.getInsertQuestRewardQuery(questReward);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertQuestsInMariaDB(Statement statement, ArrayList<Quest> quests)
    {
        for (Quest quest : quests)
        {
            insertQuery = QuestQueries.getInsertQuestQuery(quest);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertSkinsInMariaDB(Statement statement, ArrayList<Skin> skins)
    {
        for (Skin skin : skins)
        {
            insertQuery = SkinQueries.getInsertSkinQuery(skin);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterSkinsInMariaDB(Statement statement, ArrayList<CharacterSkin> characterSkins)
    {
        for (CharacterSkin characterSkin : characterSkins)
        {
            insertQuery = CharacterSkinQueries.getInsertCharacterSkinQuery(characterSkin);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }

    private static void insertCharacterQuestsInMariaDB(Statement statement, ArrayList<CharacterQuest> characterQuests)
    {
        for (CharacterQuest characterQuest : characterQuests)
        {
            insertQuery = CharacterQuestQueries.getInsertCharacterQuestQuery(characterQuest);
            MariaDBQueryExecuter.executeQuery(statement, insertQuery);
        }
    }
}
