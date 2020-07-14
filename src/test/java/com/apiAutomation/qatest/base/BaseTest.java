package com.apiAutomation.qatest.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class BaseTest {

    public final static String API_URL = "http://localhost:8080/api";
	

    /**
     * it will return request which content type is applicaiton/json
     *
     * @return RequestSpecification
     */
    public RequestSpecification getRequest() {
        RestAssured.baseURI = API_URL;
        RequestSpecification request = RestAssured.given();//
        request.header("Content-Type", "application/json");//
        return request;//return request
    }

    public boolean isSucceeded(Response response) {
        Assert.assertFalse(response.jsonPath().getBoolean("error"));//
        Assert.assertEquals(response.jsonPath().getString("message"), "");//
        return true;
    }

    public boolean isNotSucceeded(Response response) {
        Assert.assertTrue(response.jsonPath().getBoolean("error"));
        return true;
    }

}
