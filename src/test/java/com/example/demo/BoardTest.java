package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {BoardTest.class})
public class BoardTest {


    @Before
    public void setUp() {
    }


    @Test
    public void boardTest() {

        Board b = new Board(0, 0, "4,4");
        Assert.assertEquals(b.getBreadth(), 0);
        Assert.assertEquals(b.getHeight(), 0);
        Assert.assertEquals(b.getVacant_x(), 4);
        Assert.assertEquals(b.getVacant_y(), 4);
    }


}



