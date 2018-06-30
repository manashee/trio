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

    @Test
    public void _0x0Test() {

        Board b1 = new Board(0, 0);
        Assert.assertArrayEquals(b1.getTriominos(), new Trio[0]);

    }

    @Test
    public void _2x2Test() {

        Board b1 = new Board(0, 0);
        Assert.assertArrayEquals(b1.getTriominos(), new Trio[0]);

    }

    @Test
    public void _2x2Test1() {
        Board b1 = new Board(2, 2);
        Trio[] array = {new Trio(0, 0, 1, 0, 1, 1)};
        Assert.assertArrayEquals(b1.calcTriominos(2, 2, new Square(0, 0)), array);
    }


    @Test
    public void getTotalUnOccupiedSquaresTest() {
        Board b1 = new Board(2, 2);
        Square [] array = {new Square(0, 0) , new Square (0,1), new Square (1,0), new Square (1,1)};
        Assert.assertArrayEquals(b1.getTotalUnOccupiedSquares(2, 2), array);
    }


    @Test
    public void getSqauresTest() {
        Board b1 = new Board(2, 2);
        Square [] array = {new Square(0, 0) , new Square (0,1), new Square (1,0), new Square (1,1)};
        Assert.assertArrayEquals(b1.getSquares(), array);
    }

    @Test
    public void addTriominoTest() {
        Board b1 = new Board(2, 2);
        Square [] array = {new Square(0, 0) , new Square (0,1), new Square (1,0), new Square (1,1)};
        Assert.assertArrayEquals(b1.getTotalUnOccupiedSquares(2, 2), array);
    }
}



