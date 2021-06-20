package at.ac.univie.team17.controller;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoGoldOffer;
import at.ac.univie.team17.mongoDB.mongoDBmodels.MongoSkin;
import at.ac.univie.team17.service.GoldOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/maria/goldOffer/{playerId}")
    public void addGoldOfferToPlayer(@PathVariable Integer playerId, @RequestBody GoldOffer goldOffer)
    {
        goldOfferService.addGoldOfferToPlayer(playerId, goldOffer);
    }

    @PutMapping("/mongo/goldOffer/{playerId}")
    public void addMongoGoldOfferToMongoPlayer(@PathVariable Integer playerId, @RequestBody MongoGoldOffer goldOffer)
    {
        goldOfferService.addMongoGoldOfferToMongoPlayer(playerId, goldOffer);
    }

    @GetMapping("/maria/goldOffer/personalized/{playerId}")
    public GoldOffer getPersonalizedGoldOffer(@PathVariable Integer playerId)
    {
        return goldOfferService.getPersonalizedGoldOffer(playerId);
    }

    @GetMapping("/mongo/goldOffer/personalized/{playerId}")
    public MongoGoldOffer getPersonalizedMongoGoldOffer(@PathVariable Integer playerId) {
        return goldOfferService.getPersonalizedMongoGoldOffer(playerId);
    }
}
