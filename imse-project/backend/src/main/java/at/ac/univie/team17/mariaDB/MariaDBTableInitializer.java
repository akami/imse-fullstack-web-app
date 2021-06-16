package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.*;

import java.sql.Statement;

public class MariaDBTableInitializer
{
    public static void initializeMariaDBTables(Statement statement)
    {
        createPlayerTableInMariaDB(statement);
        createCharacterClassTableInMariaDB(statement);
        createPetTableInMariaDB(statement);
        createPlayerPetTableInMariaDB(statement);
        createGoldOfferTableInMariaDB(statement);
        createCharacterTableInMariaDB(statement);
        createMonsterLootTableInMariaDB(statement);
        createMonsterTableInMariaDB(statement);
        createAlliedMonsterTableInMariaDB(statement);
        createCharacterMonsterTableInMariaDB(statement);
        createQuestRewardTableInMariaDB(statement);
        createQuestTableInMariaDB(statement);
        createSkinTableInMariaDB(statement);
        createCharacterSkinTableInMariaDB(statement);
        createCharacterQuestTableInMariaDB(statement);
    }

    private static void createPlayerTableInMariaDB(Statement statement)
    {
        String createQuery = PlayerQueries.getCreatePlayerTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createCharacterTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterQueries.getCreateCharacterTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createCharacterClassTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterClassQueries.getCreateCharacterClassTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createCharacterQuestTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterQuestQueries.getCreateCharacterQuestTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createCharacterSkinTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterSkinQueries.getCreateCharacterSkinTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createGoldOfferTableInMariaDB(Statement statement)
    {
        String createQuery = GoldOfferQueries.getCreateGoldOfferTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createMonsterTableInMariaDB(Statement statement)
    {
        String createQuery = MonsterQueries.getCreateMonsterTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }
    private static void createAlliedMonsterTableInMariaDB(Statement statement)
    {
        String createQuery = AlliedMonstersQueries.getCreateAlliedMonsterTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createCharacterMonsterTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterMonsterQueries.getCreateCharacterMonsterTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createMonsterLootTableInMariaDB(Statement statement)
    {
        String createQuery = MonsterLootQueries.getCreateMonsterLootTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createPetTableInMariaDB(Statement statement)
    {
        String createQuery = PetQueries.getCreatePetTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createPlayerPetTableInMariaDB(Statement statement)
    {
        String createQuery = PlayerPetQueries.getCreatePlayerPetsTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createQuestTableInMariaDB(Statement statement)
    {
        String createQuery = QuestQueries.getCreateQuestTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createQuestRewardTableInMariaDB(Statement statement)
    {
        String createQuery = QuestRewardQueries.getCreateQuestRewardTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }

    private static void createSkinTableInMariaDB(Statement statement)
    {
        String createQuery = SkinQueries.getCreateSkinTableQuery();
        MariaDBQueryExecuter.executeNoReturnQuery(statement, createQuery);
    }
}
