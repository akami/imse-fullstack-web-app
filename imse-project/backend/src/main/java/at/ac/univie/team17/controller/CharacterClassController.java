package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.CharacterClass;
import at.ac.univie.team17.service.CharacterClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterClassController extends BackendController {
    @Autowired
    private CharacterClassService classService;

    @GetMapping(value = "/class")
    public List<CharacterClass> getCharacterClasses() {
        return classService.getCharacterClasses();
    }
}
