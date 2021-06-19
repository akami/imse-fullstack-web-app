package at.ac.univie.team17.controller;

import at.ac.univie.team17.service.PetService;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController extends BackendController {
    @Autowired
    private PetService petService;

    @GetMapping("/maria/pet")
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping("/mongo/pet")
    public List<Pet> getMongoPets() {
        return petService.getMongoPets();
    }
}
