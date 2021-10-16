package schema;

import config.Configurations;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@DisplayName("This module should validate JsonSchema")
class ListsSchemaTest {

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
                .body(matchesJsonSchemaInClasspath("schemas/getLists.json"));
    }
}
