package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import at.ac.univie.team17.service.GoldOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goldOffer")
public class GoldOfferController extends BackendController {
    @Autowired
    private GoldOfferService goldOfferService;

    @GetMapping("/goldOffer")
    public List<GoldOffer> getGoldOffers() {
        return goldOfferService.getGoldOffers();
    }

    @PostMapping("/goldOffer")
    public ResponseEntity saveGoldOffer(@RequestBody GoldOffer goldOffer) {
        goldOfferService.saveGoldOffer(goldOffer);

        return new ResponseEntity(HttpStatus.OK);
    }
}
