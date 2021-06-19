package at.ac.univie.team17;

import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoCharacterSkin;
import at.ac.univie.team17.service.CharacterSkinService;
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
        List<MongoCharacterSkin> characters = new CharacterSkinService().getMongoCharacterSkins();
        System.out.println(characters);
    }
}
