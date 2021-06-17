package at.ac.univie.team17.controller;

import at.ac.univie.team17.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DatabaseController extends BackendController {

    @Autowired
    public DatabaseService databaseService;

    @GetMapping("/initialize")
    public ResponseEntity initialize() {
        databaseService.initialize();

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/clear")
    public ResponseEntity clear() {
        databaseService.clear();

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/migrate")
    public ResponseEntity migrate() {
        databaseService.migrate();

        return new ResponseEntity(HttpStatus.OK);
    }
}
