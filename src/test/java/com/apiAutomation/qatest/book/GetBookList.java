package com.apiAutomation.qatest.book;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetBookList extends BaseTest {

    @org.junit.Test
    public void shouldReturnBooks() {
        RequestSpecification request = getRequest();
        Response response = request.get("/books");

        Assert.assertEquals(response.getStatusCode(), 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }


}
