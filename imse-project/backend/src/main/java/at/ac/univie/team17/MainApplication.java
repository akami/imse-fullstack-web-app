package at.ac.univie.team17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* TODO @kh define /api as root for all API methods */
@SpringBootApplication
public class MainApplication
{
    public static void main(String[] args)
    {
        MariaDBModel mariaDBModel = new MariaDBModel(); // TODO delete after testing? didnt run mariadb dropper and initializer without this
        mariaDBModel.initialize(); // TODO delete after testing? didnt run mariadb dropper and initializer without this
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Done");
    }
}
