package com.jwtdemo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping
    public String welcome() {
        return "welcome to jwt practise session";
    }
}
