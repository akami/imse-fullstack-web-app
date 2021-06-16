package at.ac.univie.team17;

public class BackendController
{
    private MariaDBModel mariaDBModel;
    private MongoDBModel mongoDBModel;
    private View view = new View();

    public BackendController()
    {
        mariaDBModel = new MariaDBModel();
        mongoDBModel = new MongoDBModel();
    }
}
