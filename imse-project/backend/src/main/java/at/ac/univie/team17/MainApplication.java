package at.ac.univie.team17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication
{
    public static void main(String[] args)
    {
        MariaDBModel.initialize(); // TODO delete after testing? didnt run mariadb dropper and initializer without this
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Done");
    }
}
