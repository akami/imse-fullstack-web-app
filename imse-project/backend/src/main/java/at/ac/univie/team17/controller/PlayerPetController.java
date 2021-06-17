package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.PlayerPet;
import at.ac.univie.team17.service.PetService;
import at.ac.univie.team17.service.PlayerPetService;
import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerPetController extends BackendController {
    @Autowired
    private PlayerPetService playerPetService;

    @GetMapping("/player-pet")
    public List<PlayerPet> getPlayerPets() {
        return playerPetService.getPlayerPets();
    }
}
