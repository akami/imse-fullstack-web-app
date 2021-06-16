package at.ac.univie.team17.service;

import at.ac.univie.team17.MariaDBModel;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {
    public void initialize() {
        MariaDBModel.initialize();
    }

    public void clear() {
        MariaDBModel.clear();
    }
}
