package com.example.jpademo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpademo.Entities.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByLocation(String location);
}
