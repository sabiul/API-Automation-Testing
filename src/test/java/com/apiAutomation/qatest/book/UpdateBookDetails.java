package com.apiAutomation.qatest.book;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

public class UpdateBookDetails extends BaseTest {

    @org.junit.Test
    public void shouldUpdateValidData() throws JSONException {
        String id = "1";
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        requestParams.put("author_id", 12300);

        request.body(requestParams.toString());
        Response response = request.put("/books/" + id);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
        Assert.assertNotNull(response.jsonPath().getMap("data"));
    }


    @org.junit.Test
    public void makeSureApiNotFailForInvalidData() throws JSONException {
        String id = "1";
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();
        //invalid data.
        requestParams.put("author_id", "Q23");

        request.body(requestParams.toString());
        Response response = request.put("/books/" + id);

        Assert.assertEquals(response.getStatusCode(), 500);
        //basic test
        Assert.assertTrue(isNotSucceeded(response));
    }

}
