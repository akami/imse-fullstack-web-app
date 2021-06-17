package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.mariaDB.mariaDBmodels.QuestReward;
import at.ac.univie.team17.service.QuestRewardService;
import at.ac.univie.team17.service.QuestService;
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

    @GetMapping("/quest-reward")
    public List<QuestReward> getQuestRewards() {
        return questRewardService.getQuestRewards();
    }
}
