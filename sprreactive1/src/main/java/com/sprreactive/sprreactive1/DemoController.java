package com.sprreactive.sprreactive1;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DemoController {

    @GetMapping("/mono")
    public Mono<String> getOneName() {
        // new Mono<T>();
        return Mono.just("sai-kotha");
    }

    @GetMapping("/flux")
    public Flux<Student> getMultipl() {
        return Flux.just(
                new Student(1, "sai kumar"),
                new Student(2, "sky-kotha"),
                new Student(3, "sam-vada")).delayElements(Duration.ofMillis(2000));
    }

    public record Student(Integer id, String name) {
    }

}
