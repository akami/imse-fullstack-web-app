package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class QuestService {
    public void saveQuest(Quest quest) {
        // TODO @kh save quest
    }

    public List<Quest> getQuests() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
