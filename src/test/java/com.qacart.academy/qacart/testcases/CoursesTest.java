package com.qacart.academy.qacart.testcases;

import com.qacart.academy.POJO.LoginPOJO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CoursesTest {
    @Test
    public void shouldBeAbleToGetCoursesDetails(){

        given()
                .baseUri("https://todo.qacart.com")
        .when()
                .post("/api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
