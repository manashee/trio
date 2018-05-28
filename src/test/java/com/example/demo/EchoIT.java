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
        //get("/trio?numSq=64&leaveFree?1,2").then().assertThat().body("message", equalTo("64-9"));
        get("/trio").then().assertThat().body("message", equalTo("numSq = 4 leaveFree = 9 !"));
        get("/trio?numSq=63&leaveFree=1,2").then().assertThat().body("message", equalTo("numSq = 63 leaveFree = 1,2 !"));

    }
}



