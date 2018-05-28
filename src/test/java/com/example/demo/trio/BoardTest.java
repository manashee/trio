package com.example.demo.trio;

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


    @Test
    public void boardIsVacantValidTest() {

        Board b1 = new Board(4, 4, "4,4");
        Assert.assertFalse(b1.isVacantValid());

        Board b2 = new Board(4, 4, "4,3");
        Assert.assertFalse(b2.isVacantValid());

        Board b3 = new Board(4, 4, "3,4");
        Assert.assertFalse(b3.isVacantValid());

        Board b4 = new Board(4, 4, "3,3");
        Assert.assertTrue(b4.isVacantValid());

    }


}



