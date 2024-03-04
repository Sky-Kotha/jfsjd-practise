package com.example.jpademo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.Entities.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}
