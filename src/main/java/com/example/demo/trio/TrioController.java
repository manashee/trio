package com.example.demo.trio;


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
                          @RequestParam(value = "vacant", defaultValue = "-1,-1") String vacant) throws InvalidVacantCoordinatesException {
        Board board = new Board(breadth, height, vacant);

        if (!board.isVacantValid())
            throw new InvalidVacantCoordinatesException(String.format("ERROR: Vacant square specified is outside the board. x and y coordinates of vacant square is bigger than breadth or height. breadth = %1$d, height = %2$d, vacant_x = %3d, vacant_y = %4$d", board.getBreadth(), board.getHeight(), board.getVacant_x(), board.getVacant_y()));


        return board;
    }
}
