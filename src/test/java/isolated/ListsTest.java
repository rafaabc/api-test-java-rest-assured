package isolated;

import config.Configurations;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("This module should validate the Lists endpoint")
class ListsTest {

    private String token;

    @BeforeEach
    void setUp() {
        Configurations configurations = ConfigFactory.create(Configurations.class);

        baseURI = configurations.baseURI();
        basePath = configurations.basePath();
        token = configurations.token();
    }

    @Test
    @DisplayName("When get all best-sellers, then a list of them is retrieved")
    void getGetAllBestSellers_ThenAListOfThemIsRetrieved() {

        given()
            .contentType(ContentType.JSON)
            .queryParam("api-key", token)
            .queryParam("list", "hardcover-fiction")
        .when()
            .get("/lists.json")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("status", equalTo("OK"))
                .body("copyright", equalTo("Copyright (c) 2021 The New York Times Company.  All Rights Reserved."))
                .body("num_results", equalTo(15));
    }
}
