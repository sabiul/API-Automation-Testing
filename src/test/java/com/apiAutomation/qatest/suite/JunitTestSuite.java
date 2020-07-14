package com.apiAutomation.qatest.suite;

import com.apiAutomation.qatest.author.AddAuthor;
import com.apiAutomation.qatest.author.GetAuthorList;
import com.apiAutomation.qatest.author.GetSingleAuthorDetails;
import com.apiAutomation.qatest.author.UpdateAuthorDetails;
import com.apiAutomation.qatest.book.AddBook;
import com.apiAutomation.qatest.book.GetBookList;
import com.apiAutomation.qatest.book.GetSingleBookDetails;
import com.apiAutomation.qatest.book.UpdateBookDetails;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        //author
        AddAuthor.class,
        GetAuthorList.class,
        GetSingleAuthorDetails.class,
        UpdateAuthorDetails.class,

        //book
        AddBook.class,
        GetBookList.class,
        GetSingleBookDetails.class,
        UpdateBookDetails.class
})

public class JunitTestSuite {
}