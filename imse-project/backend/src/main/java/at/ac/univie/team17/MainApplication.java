package at.ac.univie.team17;

import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterClassQueries;
import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoPlayerQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoAlliedMonsters;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacter;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterClass;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoPlayer;
import at.ac.univie.team17.service.AlliedMonsterService;
import at.ac.univie.team17.service.CharacterClassService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MainApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainApplication.class, args);
        // public static List<MongoCharacter> getMongoCharactersFromPlayer(Integer playerId)
        List<MongoAlliedMonsters> characters = new AlliedMonsterService().getMongoAlliedMonsters();
        System.out.println(characters);
    }
}
