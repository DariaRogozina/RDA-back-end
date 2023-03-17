package lesson3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lesson3.AbstractTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class SpoonacularTest extends AbstractTest {
    @Test
    @Tag("positive")
    void getVerifyingTest1() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "burger")
                .queryParam("cuisine", "Mediterranean")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void getVerifyingTest2() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "60")
                .queryParam("query", "pancakes with caviar")
                .queryParam("number", "10")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void getVerifyingTest3() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "101")
                .queryParam("minCarbs", "0")
                .queryParam("cuisine", "Mediterranean")
                .queryParam("maxReadyTime", "30")
                .queryParam("number", "10")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("negative")
    void getVerifyingTest4() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "50")
                .queryParam("minCarbs", "0")
                .queryParam("ignorePantry", "true")
                .queryParam("maxReadyTime", "30")
                .queryParam("number", "10")
                .queryParam("minProtein", "20")
                .queryParam("minVitaminD", "5")
                .queryParam("minVitaminB12", "")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(404)
                .statusLine(containsString("Not Found"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.HTML)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("negative")
    void getVerifyingTest5() {
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "50")
                .queryParam("cuisine", "European")
                .queryParam("addRecipeInformation", "true")
                .queryParam("number", "0")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("number"), is(0));
//        assertThat(response.get("vegetarian"), is(false));
//        assertThat(response.get("vegan"), is(false));
//        assertThat(response.get("license"), equalTo("CC BY-SA 3.0"));
//        assertThat(response.get("pricePerServing"), equalTo(157.06F));
//        assertThat(response.get("extendedIngredients[0].aisle"), equalTo("Milk, Eggs, Other Dairy"));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest1() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Lamb Burgers With Tzatziki Sauce")
                .formParam("ingredientList", "meat")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest2() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "de")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Corn Salsa")
                .formParam("ingredientList", "Tomate")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest3() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Vegan Beet Borscht")
                .formParam("ingredientList", "beet")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest4() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Vegan Beet Borscht")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest5() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList", "beet")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    void addMealTest() {
        Response response = given()
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"username\": \"DashaR\",\n"
                        + " \"firstName\": \"Rogoz\",\n"
                        + " \"lastName\": \"Dasha\",\n"
                        + " \"email\": \"prikhodko@yandex.ru\",\n"
                        + "}")
                .when()
                .post(getBaseUrl() + "users/connect");
        String username = response.getBody().jsonPath().get("username");
        String hash = response.getBody().jsonPath().get("hash");
        System.out.println("hashcode: " + hash);
        System.out.println("username: " + username);

        String id = given()
                .queryParam("hash", hash)
                .queryParam("apiKey", getApiKey())
                .pathParam("username", username)
                .body("{\n"
                        + "\"item\": \"2 kilograms of beets\",\n"
                        + "\"aisle\": \"Vegetables\",\n"
                        + "\"parse\": true\n"
                        + "}")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", hash)
                .queryParam("apiKey", getApiKey())
                .pathParam("username", username)
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/" + id)
                .then()
                .statusCode(200);
    }
}
