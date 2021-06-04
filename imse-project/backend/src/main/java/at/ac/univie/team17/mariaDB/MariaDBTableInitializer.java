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
        createQuestRewardTableInMariaDB(statement);
        createQuestTableInMariaDB(statement);
        createSkinTableInMariaDB(statement);
        createCharacterSkinTableInMariaDB(statement);
        createCharacterQuestTableInMariaDB(statement);
    }

    private static void createPlayerTableInMariaDB(Statement statement)
    {
        String createQuery = PlayerQueries.getCreatePlayerTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createCharacterTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterQueries.getCreateCharacterTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createCharacterClassTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterClassQueries.getCreateCharacterClassTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createCharacterQuestTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterQuestQueries.getCreateCharacterQuestTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createCharacterSkinTableInMariaDB(Statement statement)
    {
        String createQuery = CharacterSkinQueries.getCreateCharacterSkinTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createGoldOfferTableInMariaDB(Statement statement)
    {
        String createQuery = GoldOfferQueries.getCreateGoldOfferTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createMonsterTableInMariaDB(Statement statement)
    {
        String createQuery = MonsterQueries.getCreateMonsterTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createMonsterLootTableInMariaDB(Statement statement)
    {
        String createQuery = MonsterLootQueries.getCreateMonsterLootTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createPetTableInMariaDB(Statement statement)
    {
        String createQuery = PetQueries.getCreatePetTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createPlayerPetTableInMariaDB(Statement statement)
    {
        String createQuery = PlayerPetQueries.getCreatePlayerPetsTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createQuestTableInMariaDB(Statement statement)
    {
        String createQuery = QuestQueries.getCreateQuestTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createQuestRewardTableInMariaDB(Statement statement)
    {
        String createQuery = QuestRewardQueries.getCreateQuestRewardTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }

    private static void createSkinTableInMariaDB(Statement statement)
    {
        String createQuery = SkinQueries.getCreateSkinTableQuery();
        MariaDBQueryExecuter.executeQuery(statement, createQuery);
    }
}
