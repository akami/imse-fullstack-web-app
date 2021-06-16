package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Skin;
import at.ac.univie.team17.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkinController extends BackendController {
    @Autowired
    private SkinService skinService;

    @GetMapping("/skin")
    public List<Skin> getSkins() {
        return skinService.getSkins();
    }

    @PostMapping("/skin")
    public ResponseEntity saveSkin(@RequestBody Skin skin) {
        skinService.saveSkin(skin);

        return new ResponseEntity(HttpStatus.OK);
    }
}
