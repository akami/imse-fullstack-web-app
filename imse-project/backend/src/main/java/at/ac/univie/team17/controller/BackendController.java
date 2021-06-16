package at.ac.univie.team17.controller;

import at.ac.univie.team17.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/api")
public abstract class BackendController {
    @Autowired
    private PlayerService playerService;

    protected int getPlayerId(String authHeader) {
        String base64Auth = authHeader.split(" ")[1];
        String[] authDetails = new String(Base64.getDecoder().decode(base64Auth)).split(":");

        return playerService.getPlayerId(authDetails[0], authDetails[1]);
    }
}
