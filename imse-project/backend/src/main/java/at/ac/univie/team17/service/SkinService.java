package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SkinService {
    public void saveSkin(Skin skin) {
        // TODO @kh save skin
    }

    public List<Skin> getSkins() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
