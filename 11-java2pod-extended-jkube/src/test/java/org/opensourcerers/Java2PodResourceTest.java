package org.opensourcerers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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