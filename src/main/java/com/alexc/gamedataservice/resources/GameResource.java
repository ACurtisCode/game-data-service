package com.alexc.gamedataservice.resources;

import com.alexc.gamedataservice.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameResource {
    @Autowired
    GameService gameService;

}
