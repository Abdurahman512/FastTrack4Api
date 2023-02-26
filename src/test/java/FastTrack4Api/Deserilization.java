package FastTrack4Api;

import FastTrack4Api.POJO.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.awt.image.*;
import java.util.*;

import static io.restassured.RestAssured.given;

public class Deserilization extends TestBase{


    // converting response to map object
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/20");

        Map<String, Object> spartan20 = response.as(Map.class);
        System.out.println(spartan20);
    }


    // converting response to list object
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        List<Map<String, Object>> maleSpartans = response.as(List.class);
        System.out.println(maleSpartans.get(5));
        System.out.println(maleSpartans);
    }


    // converting response to custom class
    @Test
    public void test3(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/20");
        Spartan spartan20 = response.as(Spartan.class);

        System.out.println(spartan20);
    }

    @Test
    public void test4(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .and().queryParam("nameContains","va")
                .when().get("/api/spartans/search");

        Search search = response.as(Search.class);
        System.out.println(search);


    }


}

