package com.alexc.gamedataservice.resources;

import com.alexc.gamedataservice.models.Rating;
import com.alexc.gamedataservice.models.RatingList;
import com.alexc.gamedataservice.models.User;
import com.alexc.gamedataservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    @ResponseBody
    public User createUser(User user) {
        User createdUser = restTemplate.postForObject("http://localhost:8082/users/create", user, User.class);
        return createdUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User returnedUser = restTemplate.getForObject("http://localhost:8082/users/" + id, User.class);
        return returnedUser;
    }

    @PutMapping("/{id}/update")
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        ResponseEntity<User> requestUser = restTemplate.getForEntity("http://localhost:8082/users/" + id, User.class);
        if(requestUser.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<User>(restTemplate.postForObject("http://localhost:8082/update/" + id, user, User.class), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/ratings")
    public ResponseEntity<RatingList> getRatings(@PathVariable("id") Long id) {
        ResponseEntity<RatingList> ratingList= restTemplate.getForEntity("http://localhost:8082/" + id + "/ratings", RatingList.class);
        if(ratingList.getStatusCode() == HttpStatus.OK) {
            return ratingList;
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
