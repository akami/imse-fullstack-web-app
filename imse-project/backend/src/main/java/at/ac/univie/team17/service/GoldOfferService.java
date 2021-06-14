package at.ac.univie.team17.service;

import at.ac.univie.team17.mariaDB.mariaDBmodels.GoldOffer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GoldOfferService {
    public void saveGoldOffer(GoldOffer goldOffer) {
        // TODO @kh save goldOffer
    }

    public List<GoldOffer> getGoldOffers() {
        // TODO @kh access data source
        return Collections.emptyList();
    }
}
