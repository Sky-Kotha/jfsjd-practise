package com.example.jpademo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.Entities.Place;
import com.example.jpademo.Entities.User;
import com.example.jpademo.Service.PlaceService;
import com.example.jpademo.Service.UserService;

@RestController
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/places")
    public Iterable<Place> getAllDetails() {
        return placeService.getAllDetails();
    }

    @PostMapping("/places/{userId}")
    public Place addPlace(@PathVariable Integer userId, @RequestBody Place place) {
        return placeService.addPlace(userId, place);
    }

    @PutMapping("/place/{userId}")
    public void updatePlace(@PathVariable Integer userId, @RequestBody Place place) {
        placeService.updatePlace(place);
    }

    @DeleteMapping("place/{id}")
    public void deletUser(@PathVariable Integer id) {
        placeService.deletePlace(id);
    }
}
