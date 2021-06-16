package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {
    @Autowired
    private MariaDBModel mariaDBModel;

    public void initialize() {
        mariaDBModel.initialize();
    }

    public void clear() {
        mariaDBModel.clear();
    }
}
