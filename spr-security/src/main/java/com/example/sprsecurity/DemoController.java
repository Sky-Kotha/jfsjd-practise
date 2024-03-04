package com.example.sprsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String welcome() {
        return "Hi, welcome to my page";
    }
}
