package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBQueries.*;

import java.sql.Statement;

public class MariaDBTableDropper
{
    public static void dropMariaDBTables(Statement statement)
    {
        MariaDBQueryExecuter.executeNoReturnQuery(statement, CharacterQuestQueries.getDropCharacterQuestClassTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, CharacterSkinQueries.getDropCharacterSkinClassTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, SkinQueries.getDropSkinTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, QuestQueries.getDropQuestTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, QuestRewardQueries.getDropQuestRewardTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, CharacterMonsterQueries.getDropCharacterMonsterTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, AlliedMonstersQueries.getDropAlliedMonsterTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, MonsterQueries.getDropMonsterTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, MonsterLootQueries.getDropMonsterLootTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, CharacterQueries.getDropCharacterTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, GoldOfferQueries.getDropGoldOfferClassTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, PlayerPetQueries.getDropPlayerPetTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, PetQueries.getDropPetTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, CharacterClassQueries.getDropCharacterClassTableQuery());
        MariaDBQueryExecuter.executeNoReturnQuery(statement, PlayerQueries.getDropPlayerTableQuery());
    }
}
