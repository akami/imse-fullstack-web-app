package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Quest;
import at.ac.univie.team17.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quest")
public class QuestController extends BackendController {
    @Autowired
    private QuestService questService;

    @GetMapping("/quest")
    public List<Quest> getQuests() {
        return questService.getQuests();
    }

    @PostMapping("/quest")
    public ResponseEntity saveQuest(@RequestBody Quest quest) {
        questService.saveQuest(quest);

        return new ResponseEntity(HttpStatus.OK);
    }
}
