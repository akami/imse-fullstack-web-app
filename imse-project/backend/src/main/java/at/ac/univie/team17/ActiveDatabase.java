package at.ac.univie.team17;

import org.springframework.stereotype.Component;

@Component
public class ActiveDatabase
{
    private DatabaseEnum database = DatabaseEnum.MARIADB;

    public void migrate()
    {
        database = DatabaseEnum.MONGODB;
    }

    public boolean isMariadbActive()
    {
        return database.equals(DatabaseEnum.MARIADB);
    }
}
