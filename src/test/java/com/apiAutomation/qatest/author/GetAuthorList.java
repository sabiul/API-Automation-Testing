package com.apiAutomation.qatest.author;

import com.apiAutomation.qatest.base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.Assert;

public class GetAuthorList extends BaseTest {

    @Test
    public void shouldReturnAuthors() {
        RequestSpecification request = getRequest();
        Response response = request.get("/authors");

        Assert.assertEquals(response.getStatusCode(), 200);
        //basic test
        Assert.assertTrue(isSucceeded(response));
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }
}
