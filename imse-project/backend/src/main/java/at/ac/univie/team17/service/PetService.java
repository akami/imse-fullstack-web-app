package at.ac.univie.team17.service;

import at.ac.univie.team17.sharedDataModels.Pet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PetService {
    public void savePet(Pet pet) {
        // TODO @kh save pet
    }

    public List<Pet> getPets() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
