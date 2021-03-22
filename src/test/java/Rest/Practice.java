package Rest;

import static Rest.dao.UserResponce.*;
import static Rest.dao.UserRequest.*;

import Rest.dao.*;
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

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class Practice {

    @Test
    public void getSingleUser(){
        Data responseData = given().when().get("https://reqres.in/api/users/2").
                then().assertThat().statusCode(200).
                and().extract().as(Data.class);

        Assert.assertThat(responseData.getData().get("id").asInt(), equalTo(2));
        Assert.assertThat(responseData.getData().get("email").asText(), equalTo("janet.weaver@reqres.in"));
        Assert.assertThat(responseData.getSupport().get("text").asText(), equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    public void getSingleUserNotFound(){
        given().when().get("https://reqres.in/api/users/23").
                then().assertThat().statusCode(404);
    }

    @Test
    @Description("post method")
    public void postResponse(){

        UserRequest userRequest = new UserRequest("morpheus", "leader");

        UserResponce response = given().body(userRequest).
                when().post("https://reqres.in/api/users").
                then().assertThat().statusCode(201).
                and().extract().as(UserResponce.class);

        System.out.println("POST:");
        System.out.println("id: " + response.getId() + "  || createdAt: " + response.getCreatedAt());
    }

    @Test
    public void putResponseWithRequest(){
        UserRequest userRequestPUT = new UserRequest("morpheus", "zion resident");

        UserResponsePUT responsePUT = given().body(userRequestPUT).
                when().put("https://reqres.in/api/users/2").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponsePUT.class);
        System.out.println(responsePUT.getUpdatedAt() + " " + responsePUT.updatedAt);
    }

    @Test
    public void patchResponse(){
        UserRequest userRequestPATCH = new UserRequest("morpheus", "zion resident");

        UserResponsePUT responsePUT = given().body(userRequestPATCH).
                when().patch("https://reqres.in/api/users/2").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponsePUT.class);

        System.out.println(responsePUT.getUpdatedAt() + responsePUT.updatedAt);
    }

    @Test
    public void deleteResponse(){
        given().when().delete("https://reqres.in/api/users/2").
                then().assertThat().statusCode(204);
    }

    @Test
    public void postRegisterSuccessful(){
        UserRequestReg userRequestReg = new UserRequestReg("eve.holt@reqres.in", "pistol");

        UserResponseReg userResponseReg = given().contentType(ContentType.JSON).
                body(userRequestReg).
                post("https://reqres.in/api/register").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponseReg.class);

        Assert.assertThat(userResponseReg.getId(), equalTo(4));
        Assert.assertThat(userResponseReg.getToken(), equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postRegisterUnsuccessful(){
        UserRequestReg userRequestReg = new UserRequestReg("sydney@fife");

        UserResponseReg userResponseReg = given().contentType(ContentType.JSON).
                body(userRequestReg).post("https://reqres.in/api/register").
                then().assertThat().statusCode(400).
                and().extract().as(UserResponseReg.class);

        Assert.assertThat(userResponseReg.getError(), equalTo("Missing password"));
    }

    @Test
    public void postLoginSuccessful(){
        UserRequestReg userRequestReg = new UserRequestReg("eve.holt@reqres.in", "cityslicka");

        UserResponseReg userResponseReg = given().contentType(ContentType.JSON).
                body(userRequestReg).post("https://reqres.in/api/login").
                then().assertThat().statusCode(200).
                and().extract().as(UserResponseReg.class);

        Assert.assertThat(userResponseReg.getToken(), equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postLoginUnsuccessful(){
        UserRequestReg userRequestReg = new UserRequestReg("peter@klaven");

        UserResponseReg userResponseReg = given().contentType(ContentType.JSON).
                body(userRequestReg).post("https://reqres.in/api/login").
                then().assertThat().statusCode(400).
                and().extract().as(UserResponseReg.class);

        Assert.assertThat(userResponseReg.getError(), equalTo("Missing password"));
    }
}
