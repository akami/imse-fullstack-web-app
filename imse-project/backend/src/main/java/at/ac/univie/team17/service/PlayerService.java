package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PlayerService {
    public void savePlayer(Player player) {
        // TODO @kh save player
    }

    public List<Player> getPlayers() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
