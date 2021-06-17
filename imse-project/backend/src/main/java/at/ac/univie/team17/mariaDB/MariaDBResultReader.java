package at.ac.univie.team17.mariaDB;

import at.ac.univie.team17.mariaDB.mariaDBmodels.*;
import at.ac.univie.team17.sharedDataModels.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MariaDBResultReader
{
    public static ArrayList<Pet> getPetFromResultSet(ResultSet rs) {
        ArrayList<Pet> pets = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                pets.add(new Pet(rs.getInt("pet_id"), rs.getString("pet_name"), rs.getInt("gold_price")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return pets;
    }

    public static ArrayList<PlayerPet> getPlayerPetsFromResultSet(ResultSet rs) {
        ArrayList<PlayerPet> playerPets = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                playerPets.add(new PlayerPet(rs.getInt("player_id"), rs.getInt("pet_id")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return playerPets;
    }

    public static ArrayList<Player> getPlayersFromResultSet(ResultSet rs) {
        ArrayList<Player> players = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                players.add(new Player(rs.getInt("player_id"), rs.getString("user_name"),
                        rs.getInt("age"), rs.getString("email_address")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return players;
    }

    public static ArrayList<GoldOffer> getGoldOffersFromResultSet(ResultSet rs)
    {
        ArrayList<GoldOffer> goldOffers = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                goldOffers.add(new GoldOffer(rs.getInt("gold_offer_id"), rs.getBoolean("accepted"),
                        rs.getBoolean("successful"), rs.getInt("gold_amount"), rs.getInt("player_id")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return goldOffers;
    }

    public static ArrayList<Quest> getQuestsFromResultSet(ResultSet rs)
    {
        ArrayList<Quest> quest = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                quest.add(new Quest(rs.getInt("quest_id"), rs.getString("quest_name"),
                        rs.getString("client_name"), rs.getInt("quest_reward_id")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return quest;
    }

    public static QuestReward getQuestRewardFromResultSet(ResultSet rs)
    {
        try
        {
            while (rs.next())
            {
                return new QuestReward(rs.getInt("quest_reward_id"), rs.getInt("gold_amount"),
                        rs.getInt("experience_amount"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public static ArrayList<QuestReward> getQuestRewardsFromResultSet(ResultSet rs) {
        ArrayList<QuestReward> questRewards = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                questRewards.add(new QuestReward(rs.getInt("quest_reward_id"), rs.getInt("gold_amount"),
                        rs.getInt("experience_amount")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return questRewards;
    }

    public static ArrayList<Integer> getAlliedMonsterIDsFromResultSet(ResultSet rs)
    {
        ArrayList<Integer> alliedMonsterIds = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                alliedMonsterIds.add(rs.getInt("monster_id2"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return alliedMonsterIds;
    }

    public static MonsterLoot getMonsterLootFromResultSet(ResultSet rs)
    {
        try
        {
            while (rs.next())
            {
                return new MonsterLoot(rs.getInt("monster_loot_id"), rs.getInt("gold_amount"),
                        rs.getInt("experience_amount"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public static ArrayList<MonsterLoot> getMonsterLootsFromResultSet(ResultSet rs) {

        ArrayList<MonsterLoot> monsterLoots = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                monsterLoots.add(new MonsterLoot(rs.getInt("monster_loot_id"), rs.getInt("gold_amount"),
                        rs.getInt("experience_amount")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return monsterLoots;
    }

    public static ArrayList<Monster> getMonstersFromResultSet(ResultSet rs)
    {
        ArrayList<Monster> monsters = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                monsters.add(new Monster(rs.getInt("monster_id"), rs.getString("monster_name"),
                        rs.getInt("attack"), rs.getInt("lifepoints"), rs.getInt("challenge_rating"),
                        rs.getInt("monster_loot_id")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return monsters;
    }

    public static ArrayList<Skin> getSkinsFromResultSet(ResultSet rs)
    {
        ArrayList<Skin> skins = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                skins.add(new Skin(rs.getInt("skin_id"), rs.getInt("character_class_id"),
                        rs.getString("skin_name"), rs.getInt("gold_price")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return skins;
    }

    public static ArrayList<CharacterClass> getCharacterClassesFromResultSet(ResultSet rs)
    {
        ArrayList<CharacterClass> characterClasses = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                characterClasses.add(new CharacterClass(rs.getInt("character_class_id"), rs.getInt("bonus_attack"),
                        rs.getInt("bonus_lifepoints"), rs.getString("character_class_name")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return characterClasses;
    }

    public static ArrayList<GameCharacter> getGameCharactersFromResultSet(ResultSet rs)
    {
        ArrayList<GameCharacter> gameCharacters = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                gameCharacters.add(new GameCharacter(rs.getInt("character_id"), rs.getString("character_name"),
                        rs.getInt("attack"), rs.getInt("lifepoints"),
                        rs.getInt("player_id"), rs.getInt("character_class_id")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return gameCharacters;

    }
}
