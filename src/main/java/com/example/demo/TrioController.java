package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TrioController {

    private static final String template = "breadth = %1$s, height = %2$s, vacant = %3$s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/trio")
    public Board greeting(@RequestParam(value = "breadth", defaultValue = "2") int breadth,
                          @RequestParam(value = "height", defaultValue = "2") int height,
                          @RequestParam(value = "vacant", defaultValue = "0,0") String vacant) {
        return new Board(breadth, height, vacant);
    }
}
