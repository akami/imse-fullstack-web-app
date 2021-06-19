package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuest;
import at.ac.univie.team17.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestController extends BackendController {
    @Autowired
    private QuestService questService;

    @GetMapping("/maria/quest")
    public List<Quest> getQuests() {
        return questService.getQuests();
    }

    @GetMapping("/mongo/quest")
    public List<MongoQuest> getMongoQuests() {
        return questService.getMongoQuests();
    }
}
