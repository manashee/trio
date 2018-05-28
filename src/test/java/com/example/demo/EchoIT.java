package com.example.demo;

import com.jayway.restassured.RestAssured;
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

        get("/trio").then().assertThat().body("message", equalTo("breadth = 2, height = 2, vacant = 0,0"));
        get("/trio?breadth=8&height=8&vacant=7,7").then().assertThat().body("message", equalTo("breadth = 8, height = 8, vacant = 7,7"));

    }

    @Test
    public void _4x4Test() {


        //get("/trio?breadth=4&height=4&vacant=0,0").then().assertThat().body("message", equalTo("{ }"));

    }

}



