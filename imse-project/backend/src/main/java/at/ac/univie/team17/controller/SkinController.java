package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkinController extends BackendController {
    @Autowired
    private SkinService skinService;

    @GetMapping("/skin")
    public List<Skin> getSkins() {
        return skinService.getAllSkins();
    }

    @GetMapping("/skin/{classId}")
    public List<Skin> getSkinsFromClassId(@PathVariable Integer classId) {
        return skinService.getSkinsFromClassId(classId);
    }
}
