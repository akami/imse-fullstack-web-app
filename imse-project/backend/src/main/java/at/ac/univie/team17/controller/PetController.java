package at.ac.univie.team17.controller;

import at.ac.univie.team17.sharedDataModels.Pet;
import at.ac.univie.team17.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController extends BackendController {

    @Autowired
    private PetService petService;

    @GetMapping("/pet")
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @PostMapping("/pet")
    public ResponseEntity savePet(@RequestBody Pet pet) {
        petService.savePet(pet);

        return new ResponseEntity(HttpStatus.OK);
    }
}
