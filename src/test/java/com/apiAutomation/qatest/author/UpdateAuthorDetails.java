package com.apiAutomation.qatest.author;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

public class UpdateAuthorDetails extends BaseTest {

    @org.junit.Test
    public void shouldUpdateValidData() throws JSONException {
        String id = "4";
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test1");
        requestParams.put("mobile", "01710000001");

        request.body(requestParams.toString());
        Response response = request.put("/authors/" + id);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
        Assert.assertNotNull(response.jsonPath().getMap("data"));
    }


    @org.junit.Test
    public void makeSureApiNotFailForInvalidData() throws JSONException {
        String id = "4";
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test1");
        //mobile is required field.
        //requestParams.put("mobile", "01710000001");

        request.body(requestParams.toString());
        Response response = request.put("/authors/" + id);

        Assert.assertEquals(response.getStatusCode(), 500);
        //basic test
        Assert.assertTrue(isNotSucceeded(response));
    }
}
