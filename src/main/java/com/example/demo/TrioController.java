package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TrioController {

    private static final String template = "numSq = %1$s leaveFree = %2$s !";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/trio")
    public Trio greeting(@RequestParam(value = "numSq", defaultValue = "4") int numSq,
                         @RequestParam(value = "leaveFree", defaultValue = "9") String leaveFree) {
        return new Trio(counter.incrementAndGet(),
                String.format(template, numSq, leaveFree));
    }
}
