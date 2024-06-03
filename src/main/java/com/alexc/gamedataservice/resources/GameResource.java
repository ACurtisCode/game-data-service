package com.alexc.gamedataservice.resources;

import com.alexc.gamedataservice.models.Game;
import com.alexc.gamedataservice.services.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/games")
public class GameResource {
    @Autowired
    GameService gameService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable("id") Long id) {
        ResponseEntity<Game> returnedGame = restTemplate.getForEntity("http://localhost:8082/games/" + id, Game.class);
        if(returnedGame.getStatusCode() == HttpStatus.OK) {
            return returnedGame;
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/rawg/{id}")
    public ResponseEntity<Game> getRawgGame(@PathVariable("id") Long id) {
        ResponseEntity<Game> returnedGame = restTemplate.getForEntity("http://localhost:8081/games" + id, Game.class);
        return returnedGame;
    }

    @PostMapping("/{id}")
    @ResponseBody
    public postGameToDb(Game game) {
        restTemplate.postForObject("http://localhost:8082/games" + )
    }



}
