package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoQuestRewardWithIds;
import at.ac.univie.team17.service.QuestRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestRewardController extends BackendController {
    @Autowired
    private QuestRewardService questRewardService;

    @GetMapping("/maria/quest-reward")
    public List<QuestReward> getQuestRewards() {
        return questRewardService.getQuestRewards();
    }

    @GetMapping("/mongo/quest-reward")
    public List<MongoQuestRewardWithIds> getMongoQuestRewards() {
        return questRewardService.getMongoQuestRewards();
    }
}
