package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.*;

import java.sql.Statement;

public class MariaDBTableDropper
{
    public static void dropMariaDBTables(Statement statement)
    {
        MariaDBQueryExecuter.executeQuery(statement, CharacterQuestQueries.getDropCharacterQuestClassTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, CharacterSkinQueries.getDropCharacterSkinClassTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, SkinQueries.getDropSkinTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, QuestQueries.getDropQuestTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, QuestRewardQueries.getDropQuestRewardTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, MonsterQueries.getDropMonsterTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, MonsterLootQueries.getDropMonsterLootTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, CharacterQueries.getDropCharacterTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, GoldOfferQueries.getDropGoldOfferClassTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, PlayerPetQueries.getDropPlayerPetTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, PetQueries.getDropPetTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, CharacterClassQueries.getDropCharacterClassTableQuery());
        MariaDBQueryExecuter.executeQuery(statement, PlayerQueries.getDropPlayerTableQuery());
    }
}
