package com.qacart.academy.qacart.testcases;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.Matchers.equalTo;

public class InfoTest {
    @Test
    public void shouldBeAbleToGetCoursesInfo(){
        Header langHeader = new Header("language", "JAVA");
        Header typeHeader = new Header("type", "MANUAL");

        HashMap<String, String> infoHeader2 = new HashMap<>();
        infoHeader2.put("type", "WEB");
        infoHeader2.put("language", "JAVA");
        Headers infoHeader  = new Headers(langHeader, typeHeader);
        given()
                .baseUri("https://todo.qacart.com")
//                .header("type", "MANUAL")
//                .header("language", "JAVA")
//                .header(langHeader)
//                .headers("type", "MANUAL", "language", "JAVA")
//                .headers(infoHeader)
                .headers(infoHeader2)
        .when()
                .get("/api/v1/info/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("count", equalTo(1));

    }

    @Test
    public void shouldBeAbleToGetLecturesInfo(){
        HashMap<String, String> queries= new HashMap<String, String>();
        queries.put("mode", "VIDEO");
        queries.put("type", "FREE");
        given()
                .baseUri("https://todo.qacart.com")
//                .queryParam("mode", "VIDEO")
//                .queryParam("type", "FREE")
                .queryParams(queries)
        .when()
                .get("/api/v1/info/lectures")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

}
