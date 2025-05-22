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

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class test {
    @Test
    public void test(){
        given().baseUri("https://68229394b342dce8004eb1ed.mockapi.io/api/v1")
        .when().get("users")
         //print everything related tothe response
        .then().log().all()
                //instead of doing that
                //equalto comes from hamcrest.Matchers
//                .assertThat().body("[1].name", equalTo("Dr. Belinda Okuneva"))
//                .assertThat().body("name", hasItem("Dr. Belinda Okuneva"))
                //do that
                .assertThat().body("[1].name", equalTo("Dr. Belinda Okuneva"),
                //instead of data.name we do:
                "name", hasItem("Dr. Belinda Okuneva"),
                "name", hasItems("Miss Georgia Braun", "Sam Cummerata", "Alberto Rohan"),
                "name", not(hasItem("khaled")),
                "name", not(empty()),
                "name", hasSize(17),
                "name.size()", equalTo(17),
                "createdAt", everyItem(startsWith("2025-05-12")),
                //make sure that object has specific kry
                "[0]", hasKey("id"),
                "[0]", hasValue("1"),
                "[0]", hasEntry("id", "1")
                )
                .assertThat().statusCode(200);



    }
    @Test
    public void Extract() {
        //extract response
        Response res = given().baseUri("https://68229394b342dce8004eb1ed.mockapi.io/api/v1")
                .when().get("users")
                .then().extract().response();
        //path is method which take groovy query to extract the response
        String name = res.path("[0].name");
        System.out.println(name);
        //instead of the 2 lines above we can just do:
        String name2 = JsonPath.from(res.asString()).getString("[0].name");
        System.out.println(name2);


    }

    @Test
    public void Log() {
        given().baseUri("https://68229394b342dce8004eb1ed.mockapi.io/api/v1").log().all()
                .when().get("users")
                .then();
        given().baseUri("https://68229394b342dce8004eb1ed.mockapi.io/api/v2")
                .when().get("users")
                .then().log().ifError();
        given().baseUri("https://68229394b342dce8004eb1ed.mockapi.io/api/v2")
                .when().get("users")
                .then().log().ifValidationFails()
                .assertThat().statusCode(200);
    }
}
