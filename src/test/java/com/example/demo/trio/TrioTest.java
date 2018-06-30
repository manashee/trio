package com.example.demo.trio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TrioTest.class})
public class TrioTest {

    @Before
    public void setUp() {
    }

    @Test
    public void trioEqualityTest() {

        Trio t = new Trio(0,0,0,1,1,1);
        Trio t1 = new Trio(0,0,0,1,1,1);
        Assert.assertEquals(t, t1);
    }

    @Test
    public void makeLTest() {

        int ax = 0;
        int ay = 0;
        Trio expected = new Trio (0, 0, 0, 1, 1,1);

        Trio actual = Trio.makeL(ax,ay);
        Assert.assertEquals(expected, actual);
    }
}





