package at.ac.univie.team17;

import at.ac.univie.team17.mongoDB.mongoDBQueries.MongoCharacterQueries;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkinReport;
import at.ac.univie.team17.service.SkinService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class MainApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainApplication.class, args);
        System.out.println(MongoCharacterQueries.getMongoSkinReports());
    }
}
