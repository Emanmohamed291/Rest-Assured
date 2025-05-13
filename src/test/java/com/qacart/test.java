package com.qacart;

//instead of using "import io.restassured.RestAssured;" then use
// //method chain
// RestAssured
//        .given()
//        .when()
//        .then();
//we can do the following:
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class test {
    @Test
    public void test(){
        given().when().then();
    }

}
