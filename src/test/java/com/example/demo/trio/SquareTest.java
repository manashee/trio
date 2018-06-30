package com.example.demo.trio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SquareTest.class})
public class SquareTest {

    @Before
    public void setUp() {
    }


    @Test
    public void squareEqualityTest() {

        Square s = new Square(0,0);
        Square s1 = new Square(0,0);
        Assert.assertEquals(s, s1);
    }

    @Test
    public void onEastTest() {

        Square cell = new Square(1,1);
        Square same = new Square(1,1);
        Square east = new Square(2,1);
        Square west = new Square(0,1);
        Square north = new Square(1,0);
        Square south = new Square(1,2);
        Square north_west = new Square(0,0);
        Square north_east = new Square(2,0);
        Square south_west = new Square(0,2);
        Square soth_east = new Square(2,2);
        Assert.assertFalse(cell.onEast(same));

        Assert.assertFalse(cell.onEast(west));
        Assert.assertFalse(cell.onEast(north));
        Assert.assertFalse(cell.onEast(south));
        Assert.assertFalse(cell.onEast(north_west));
        Assert.assertFalse(cell.onEast(north_east));
        Assert.assertFalse(cell.onEast(south_west));
        Assert.assertFalse(cell.onEast(soth_east));
        Assert.assertTrue(cell.onEast(east));


    }


    @Test
    public void onWestTest() {

        Square cell = new Square(1,1);
        Square same = new Square(1,1);
        Square east = new Square(2,1);
        Square west = new Square(0,1);
        Square north = new Square(1,0);
        Square south = new Square(1,2);
        Square north_west = new Square(0,0);
        Square north_east = new Square(2,0);
        Square south_west = new Square(0,2);
        Square soth_east = new Square(2,2);

        Assert.assertFalse(cell.onWest(same));
        Assert.assertFalse(cell.onWest(east));
        Assert.assertFalse(cell.onWest(north));
        Assert.assertFalse(cell.onWest(south));
        Assert.assertFalse(cell.onWest(north_west));
        Assert.assertFalse(cell.onWest(north_east));
        Assert.assertFalse(cell.onWest(south_west));
        Assert.assertFalse(cell.onWest(soth_east));
        Assert.assertTrue (cell.onWest(west));
    }


    @Test
    public void onNorthTest() {

        Square cell = new Square(1,1);
        Square same = new Square(1,1);
        Square east = new Square(2,1);
        Square west = new Square(0,1);
        Square north = new Square(1,0);
        Square south = new Square(1,2);
        Square north_west = new Square(0,0);
        Square north_east = new Square(2,0);
        Square south_west = new Square(0,2);
        Square soth_east = new Square(2,2);

        Assert.assertFalse(cell.onNorth(same));
        Assert.assertFalse(cell.onNorth(east));
        Assert.assertFalse(cell.onNorth(west));
        Assert.assertFalse(cell.onNorth(south));
        Assert.assertFalse(cell.onNorth(north_west));
        Assert.assertFalse(cell.onNorth(north_east));
        Assert.assertFalse(cell.onNorth(south_west));
        Assert.assertFalse(cell.onNorth(soth_east));
        Assert.assertTrue (cell.onNorth(north));
    }

    @Test
    public void onSouthTest() {

        Square cell = new Square(1,1);
        Square same = new Square(1,1);
        Square east = new Square(2,1);
        Square west = new Square(0,1);
        Square north = new Square(1,0);
        Square south = new Square(1,2);
        Square north_west = new Square(0,0);
        Square north_east = new Square(2,0);
        Square south_west = new Square(0,2);
        Square soth_east = new Square(2,2);

        Assert.assertFalse(cell.onSouth(same));
        Assert.assertFalse(cell.onSouth(east));
        Assert.assertFalse(cell.onSouth(west));
        Assert.assertFalse(cell.onSouth(north));
        Assert.assertFalse(cell.onSouth(north_west));
        Assert.assertFalse(cell.onSouth(north_east));
        Assert.assertFalse(cell.onSouth(south_west));
        Assert.assertFalse(cell.onSouth(soth_east));
        Assert.assertTrue (cell.onSouth(south));
    }


}





