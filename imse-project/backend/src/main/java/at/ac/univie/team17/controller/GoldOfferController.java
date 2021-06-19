package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import at.ac.univie.team17.service.GoldOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO @ĸh

@RestController
@RequestMapping("/api")
public class GoldOfferController extends BackendController {
    @Autowired
    private GoldOfferService goldOfferService;

    @GetMapping("/maria/goldOffer")
    public List<GoldOffer> getGoldOffers(int playerId) {
        return goldOfferService.getGoldOffersByPlayerId(playerId);
    }

    @GetMapping("/mongo/goldOffer")
    public List<MongoGoldOffer> getMongoGoldOffers(int playerId) {
        return goldOfferService.getMongoGoldOffersByPlayerId(playerId);
    }
}
