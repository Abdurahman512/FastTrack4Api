package FastTrack4Api;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class RequestAndResponse extends TestBase{

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("http://3.87.65.105:8000/api/spartans/25");

        System.out.println(response.statusCode());
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertTrue(response.headers().exist());
        Assertions.assertEquals("application/json",response.header("Content-Type"));

    }

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/25");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Valentin",response.path("name"));
        Assertions.assertEquals("Male",response.path("gender"));
    }


}
