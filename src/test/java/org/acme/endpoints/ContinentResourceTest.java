package org.acme.endpoints;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class ContinentResourceTest {

    @Test
    void getAll() {
        given()
                .when().get("/continent")
                .then()
                .statusCode(200)
                .body(
                        containsString("Afrique")

                );
    }

    @Test
    void getById() {
    }

    @Test
    void count() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}