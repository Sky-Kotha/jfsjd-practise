package com.example.jpademo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.Entities.Place;
import com.example.jpademo.Entities.User;
import com.example.jpademo.Repository.PlaceRepository;
import com.example.jpademo.Repository.UserRepository;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public Iterable<Place> getAllDetails() {
        return placeRepository.findAll();
    }

    public Place addPlace(Integer id, Place place) {
        place.setUser(new User(id, "", ""));
        return placeRepository.save(place);
    }

    public void updatePlace(Place place) {
        placeRepository.save(place);
    }

    public void deletePlace(Integer id) {
        placeRepository.deleteById(id);
    }

}
