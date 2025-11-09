package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
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
            String body = """
                        {
                        "your-name": "Jan Kowalski",
                        "your-email": "jan.kowalski@example.com",
                        "your-subject": "Zapytanie testowe",
                        "your-message": "To jest test automatycznego wysłania formularza kontaktowego."
                        }
                    """;

            given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post("/wp-json/contact-form-7/v1/contact-forms/123/feedback")
                    .then()
                    .statusCode(201)
                    .body("success", equalTo(true));
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
