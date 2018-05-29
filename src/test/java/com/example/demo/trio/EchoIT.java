package com.example.demo.trio;

import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes = {EchoIT.class}, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EchoIT {

    @Autowired
    ServerProperties serverProperties;

    @Autowired
    Environment environment;


    @LocalServerPort
    private int randomPort;

    public String getPath() {
        //final int port = environment.getProperty("local.server.port", Integer.class);

        return "http://localhost:" + randomPort;
    }

    @Before
    public void setUp() {
        // RestAssured.baseURI = getPath();
        RestAssured.port = 8080;
    }


    @Test
    public void trioTest() {

        get("/trio?breadth=4&height=4&vacant=3,3").then().assertThat().body
                ("breadth", equalTo(4)
                        , "height", equalTo(4)
                        , "vacant_x", equalTo(3)
                        , "vacant_y", equalTo(3)
                );

    }

    @Test
    // This does not throw exception (expected = InvalidVacantCoordinatesException.class)
    public void InvalidVacantCoordinatesExceptionTest() {

        get("/trio?breadth=8&height=8&vacant=8,8").then().assertThat().body
                ("breadth", equalTo(null)
                        , "height", equalTo(null)
                        , "vacant_x", equalTo(null)
                        , "vacant_y", equalTo(null)
                        , "message", equalTo("ERROR: Vacant square specified is outside the board. x and y coordinates of vacant square is bigger than breadth or height. breadth = 8, height = 8, vacant_x =   8, vacant_y = 8")
                );

    }


    @Test
    public void VacantCoordinatesNotSpecifiedTest() {

        get("/trio?breadth=8&height=8").then().assertThat().body
                ("breadth", equalTo(8)
                        , "height", equalTo(8)
                        , "vacant_x", equalTo(-1)
                        , "vacant_y", equalTo(-1)
                );
    }

    @Test
    public void _0x0Test() {

        get("/trio?breadth=0&height=0").then().assertThat().body
                ("breadth", equalTo(0)
                        , "height", equalTo(0)
                        , "vacant_x", equalTo(-1)
                        , "vacant_y", equalTo(-1)
                        , "triominos", Matchers.hasSize(0)
                );
    }


    @Test
    public void _1x1Test() {

        get("/trio?breadth=0&height=0").then().assertThat().body
                ("breadth", equalTo(0)
                        , "height", equalTo(0)
                        , "vacant_x", equalTo(-1)
                        , "vacant_y", equalTo(-1)
                        , "triominos", Matchers.hasSize(0)
                );
    }

}



