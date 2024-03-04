package com.example.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entities.Obj;

@RestController
public class ObjController {

    @Autowired
    RestTemplate temp;

    @GetMapping("/obj/users")
    List<Object> getUsers() {
        Object[] arr = temp.getForObject("http://localhost:8081/users", Object[].class);
        return Arrays.asList(arr);
    }

    @PostMapping("/obj/users")
    String addUser(@RequestBody Obj obj) {
        return temp.postForObject("http://localhost:8081/users", obj, String.class);
    }
}
