package com.apiAutomation.qatest.author;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class AddAuthor extends BaseTest {

    @Test
    public void testAddAuthorForValidData() throws JSONException {
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("email", "test@server.com");
        requestParams.put("mobile", "01710000000");
        requestParams.put("address", "Dhaka");

        request.body(requestParams.toString());//
        Response response = request.post("/authors");//

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
    }

    @Test
    public void testAddBookForNotValidData() throws JSONException {
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test"); // Cast
        requestParams.put("email", "test@server.com");
        //missing field
        //requestParams.put("mobile", "01710000000");
        requestParams.put("address", "Dhaka");
        request.body(requestParams.toString());

        Response response = request.post("/authors");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);//400
        //basic test
        Assert.assertTrue(isNotSucceeded(response));
        Assert.assertEquals(response.jsonPath().getString("message"), "Parameter 'mobile' is required");
    }
}
