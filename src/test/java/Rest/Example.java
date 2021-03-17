package Rest;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class Example {

    public static String url = "http://ergast.com/api/f1/2017/circuits.json";

    @Test
    public void Task1(){

        given().when().get(url).then().assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
    }

    @Test
    public void Task2(){

        given().when().get(url).then().assertThat().statusCode(200).
                and().header("Content-Length", equalTo("4551")).
                and().contentType(equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void Task3() {

        String text = "test";
        String expectedMd5 = "098f6bcd4621d373cade4e832627b4f6";
        String url = "http://md5.jsontest.com";

        given().param("text", text). when().get(url).then().
                assertThat().body("md5", equalTo(expectedMd5));
    }

    @Test
    public void Task4() {

        String season = "2017";
        int numberOfRaces = 20;
        String url = "http://ergast.com/api/f1/{raceSeason}/circuits.json";

        given().pathParam("raceSeason",season).when().get(url).then().
                assertThat().body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
    }
}
