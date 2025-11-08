import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.oneOf;

class RestApi {

        @BeforeAll
        static void setup() {
            RestAssured.baseURI = "https://designvalue.pl";
        }

        @Test
        void homepageShouldReturn200() {
            given()
                    .when()
                    .get("/")
                    .then()
                    .statusCode(200);
        }

        @Test
        void shouldContainExpectedHeaders() {
            given()
                    .when()
                    .get("/")
                    .then()
                    .statusCode(200)
                    .header("Content-Type", containsString("text/html"));
        }


        @Test
        void sendContactMessageShouldReturn201() {
            given()
                    .contentType(ContentType.JSON)
                    .body("""
                {
                "name": "Jan Kowalski",
                "email": "jan@example.com",
                "subject": "Test",
                "message": "To jest test wiadomości."
                }
            """)
                    .when()
                    .post("/api/contact")
                    .then()
                    .statusCode(oneOf(200, 201));
    }
        @Test
        void contactPageShouldBeAccessible() {
            when()
                    .get("/kontakt")
                    .then()
                    .statusCode(200)
                    .body(containsString("Kontakt"));
    }

        @Test
        void robotsTxtShouldExist() {
            when()
                    .get("/robots.txt")
                    .then()
                    .statusCode(oneOf(200, 404));
    }

        @Test
        void faviconShouldBeAccessible() {
            when()
                    .get("/favicon.ico")
                    .then()
                    .statusCode(oneOf(200, 304)); // często cache'owany
    }
}
