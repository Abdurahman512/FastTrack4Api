package FastTrack4Api;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class RequestAndResponse {

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.87.65.105:8000/api/spartans/25");

        System.out.println(response.statusCode());
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertTrue(response.headers().exist());
        Assertions.assertEquals("application/json",response.header("Content-Type"));

    }


}
