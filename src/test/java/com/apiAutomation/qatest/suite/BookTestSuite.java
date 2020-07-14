package com.apiAutomation.qatest.suite;

import com.apiAutomation.qatest.book.AddBook;
import com.apiAutomation.qatest.book.GetBookList;
import com.apiAutomation.qatest.book.GetSingleBookDetails;
import com.apiAutomation.qatest.book.UpdateBookDetails;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AddBook.class,
        GetBookList.class,
        GetSingleBookDetails.class,
        UpdateBookDetails.class
})

public class BookTestSuite {
}