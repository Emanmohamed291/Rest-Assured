package com.qacart.academy.qacart.testcases;

import com.qacart.academy.POJO.LoginPOJO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentsTest {
    @Test
    public void shouldBeAbleToLoginTheApplication(){
        /* if i want to send it as a json file */
        File bodyFile = new File("src/test/resources/Login.json");
        /* if i want to use hash map but here we need to do serialization(from hashmap/java object to json) and deserialization(from json to hashmap/java object
        so we need to download a dependancy in pom(jackson Databind) and it do tat automatically
         */
        HashMap<String, String> bodyMap = new HashMap<String, String>();
        bodyMap.put("email", "hatem@example.com");
        bodyMap.put("password", "Test1234");

        /* using POJO class , the serialization and deserialization done also automatically */
        LoginPOJO bodyPOJO = new LoginPOJO();
        bodyPOJO.setEmail("hatem@example.com");
        bodyPOJO.setPassword("Test1234");

        given()
                .baseUri("https://todo.qacart.com")
//                .body("{\n" +
//                        "    \"email\": \"hatem@example.com\",\n" +
//                        "    \"password\": \"Test1234\"\n" +
//                        "}")
                //.body(bodyFile)
                //.body(bodyMap)
                .body(bodyPOJO)
                /* choose any of the following */
                // .header("Content-Type", "application/json")
                //.contentType("application/json")
                .contentType(ContentType.JSON)
        .when()
                .post("/api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
