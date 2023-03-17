package lesson4;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.lesson4.ResponseList;
import org.example.lesson4.ShoppingList1;

import org.example.lesson4.UserForm;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RefactorSpoonacularTest extends AbstractTest{
    @Test
    @Tag("positive")
    void getVerifyingTest1() {
        given().spec(getRequestSpecification())
                .queryParam("query", "burger")
                .queryParam("cuisine", "Mediterranean")
                .when()
                .get(getBaseUrl() + SEARCH)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void getVerifyingTest2() {
        given().spec(getRequestSpecification())
                .queryParam("maxCarbs", "60")
                .queryParam("query", "pancakes with caviar")
                .queryParam("number", "10")
                .when()
                .get(getBaseUrl() + SEARCH)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void getVerifyingTest3() {
        given().spec(getRequestSpecification())
                .queryParam("maxCarbs", "101")
                .queryParam("minCarbs", "0")
                .queryParam("cuisine", "Mediterranean")
                .queryParam("maxReadyTime", "30")
                .queryParam("number", "10")
                .when()
                .get(getBaseUrl() + SEARCH)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void getVerifyingTest4() {
        given().spec(getRequestSpecification())
                .queryParam("maxCarbs", "50")
                .queryParam("minCarbs", "0")
                .queryParam("ignorePantry", "true")
                .queryParam("maxReadyTime", "30")
                .queryParam("number", "10")
                .queryParam("minProtein", "20")
                .queryParam("minVitaminD", "5")
                .queryParam("minVitaminB12", "10")
                .when()
                .get(getBaseUrl() + SEARCH)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("negative")
    void getVerifyingTest5() {
        JsonPath response = given().spec(getRequestSpecification())
                .queryParam("maxCarbs", "50")
                .queryParam("cuisine", "European")
                .queryParam("addRecipeInformation", "true")
                .queryParam("number", "0")
                .when()
                .get(getBaseUrl() + SEARCH)
                .body()
                .jsonPath();
        assertThat(response.get("number"), is(0));
    }

    @Test
    @Tag("positive")
    void postVerifyingTest1() {
        given().spec(getRequestSpecification())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Lamb Burgers With Tzatziki Sauce")
                .formParam("ingredientList", "meat")
                .when()
                .post(getBaseUrl() + CLASSIFY_CUISINE)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void postVerifyingTest2() {
        given().spec(getRequestSpecification())
                .queryParam("language", "de")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Corn Salsa")
                .formParam("ingredientList", "Tomate")
                .when()
                .post(getBaseUrl() + CLASSIFY_CUISINE)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void postVerifyingTest3() {
        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Vegan Beet Borscht")
                .formParam("ingredientList", "beet")
                .when()
                .post(getBaseUrl() + CLASSIFY_CUISINE)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void postVerifyingTest4() {
        given().spec(getRequestSpecification())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Vegan Beet Borscht")
                .when()
                .post(getBaseUrl() + CLASSIFY_CUISINE)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    @Tag("positive")
    void postVerifyingTest5() {
        given().spec(getRequestSpecification())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList", "beet")
                .when()
                .post(getBaseUrl() + CLASSIFY_CUISINE)
                .then()
                .spec(getResponseSpecification());
    }

    @Test
    void addMealTest() {
        ShoppingList1 shoppingList = new ShoppingList1("2 kilograms of beets", "Vegetables", true);
        UserForm userForm = new UserForm("DashaR","Rogoz","Dasha", "prikhodko@yandex.ru");

        Response response = given().spec(getRequestSpecification())
                .body(userForm)
                .when()
                .post(getBaseUrl() + "users/connect");
        String username = response.getBody().jsonPath().get("username");
        String hash = response.getBody().jsonPath().get("hash");
        System.out.println("hashcode: " + hash);
        System.out.println("username: " + username);

        String id = given().spec(getRequestSpecification())
                .queryParam("hash", hash)
                .pathParam("username", username)
                .body(shoppingList)
                .when()
                .post(getBaseUrl() + SHOPPING_LIST)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .jsonPath()
                .get("id")
                .toString();
        given().spec(getRequestSpecification())
                .queryParam("hash", hash)
                .pathParam("username", username)
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then()
                        .spec(getResponseSpecification());
//       ResponseList responseList = given().spec(getRequestSpecification())
//                .queryParam("hash", hash)
//                .pathParam("username", username)
//                .when()
//                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
//                .then()
//               .extract()
//               .response()
//               .body()
//               .as(ResponseList.class);
//       assertThat(responseList.getName(),containsString("beets"));

        given().spec(getRequestSpecification())
                .queryParam("hash", hash)
                .pathParam("username", username)
                .delete(getBaseUrl() + SHOPPING_LIST + "/" + id)
                .then()
                .spec(getResponseSpecification());
    }
}
