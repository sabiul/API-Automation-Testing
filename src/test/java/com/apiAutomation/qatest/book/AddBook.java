package com.apiAutomation.qatest.book;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class AddBook extends BaseTest {

    @Test
    public void shouldPassForValidData() throws JSONException {
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();

        requestParams.put("author_id", 123);
        requestParams.put("image_url", "http://example.com/image.jpg");


        JSONObject title = new JSONObject();
        title.put("en", "My Book name in english");
        title.put("bn", "My Book name in bangla");
        requestParams.put("title", title);

        JSONObject description = new JSONObject();
        description.put("en", "Book description in english");
        description.put("bn", "Book description in bangla");
        requestParams.put("description", description);

        request.body(requestParams.toString());
        Response response = request.post("/books");

        Assert.assertEquals(response.getStatusCode(), 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
    }

    @Test
    public void makeSureApiNotFailForInvalidData() throws JSONException {
        RequestSpecification request = getRequest();
        JSONObject requestParams = new JSONObject();

        requestParams.put("author_id", 123);
        requestParams.put("image_url", "http://example.com/image.jpg");


        JSONObject title = new JSONObject();
        //en required field
//        title.put("en", "My Book name in english");
        title.put("bn", "My Book name in bangla");
        requestParams.put("title", title);

        JSONObject description = new JSONObject();
        description.put("en", "Book description in english");
        description.put("bn", "Book description in bangla");
        requestParams.put("description", description);

        request.body(requestParams.toString());
        Response response = request.post("/books");

        Assert.assertEquals(response.getStatusCode(), 400);
        //basic test
        Assert.assertTrue(isNotSucceeded(response));
        Assert.assertEquals(response.jsonPath().getString("message"), "Field 'title.en' is required");
    }
}
