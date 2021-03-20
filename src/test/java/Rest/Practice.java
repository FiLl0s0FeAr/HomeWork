package Rest;

import static Rest.dao.UserResponce.*;
import static Rest.dao.UserRequest.*;

import Rest.dao.UserRequest;
import Rest.dao.UserResponce;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Practice {

    @Test
    @Description("post method")
    public void getResponce(){

        UserRequest userRequest = new UserRequest("morpheus", "leader");

        UserResponce responce = given().body(userRequest).log().all().
                when().post("https://reqres.in/api/users").
                then().assertThat().statusCode(201).
                and().extract().as(UserResponce.class);

        System.out.println(responce.getId() + " " + responce.getCreatedAt());
    }
}
