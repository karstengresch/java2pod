package org.opensourcerers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class Java2PodResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/java2pod")
          .then()
             .statusCode(200)
             .body(is("Your environment ID is: local"));
    }

}