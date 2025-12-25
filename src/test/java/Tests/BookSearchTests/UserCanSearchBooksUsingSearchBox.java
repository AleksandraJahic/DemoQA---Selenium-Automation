package Tests.BookSearchTests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserCanSearchBooksUsingSearchBox extends BaseTest {

    @BeforeMethod
    public void pageSetUp()  {
        navigateToBookstore();
    }

    @Test
    public void searchTheStoreWithFullTitle() {
    String bookTitle = excelReader.getStringData("BookTitles", 1, 0);

    bookStore.typeInSearchBox(bookTitle);
    bookStore.clickSearch();

        Assert.assertTrue(bookStore.isBookTitleDisplayed(bookTitle));
    }

    @Test
    public void searchTheStoreWithAuthor() {
        String author = excelReader.getStringData("BookTitles", 4, 1);

        bookStore.typeInSearchBox(author);
        bookStore.clickSearch();

        Assert.assertTrue(bookStore.isAuthorDisplayed(author));

    }

    @Test
    public void partialSearch() throws InterruptedException {
        String name = excelReader.getStringData("BookTitles", 4, 0);
        String partOfTheName = name.substring(0,3); //substring - pretraga dela stringa, prvi broj je index odakle pocinjemo, drugi broj karaktera
        bookStore.typeInSearchBox(partOfTheName);
        bookStore.clickSearch();

        Assert.assertTrue(bookStore.isStringContained(partOfTheName));


    }
    @Test
    public void oneLetterSearch() throws InterruptedException {
        String letter = "b";
        bookStore.typeInSearchBox(letter);
        bookStore.clickSearch();
        Assert.assertTrue(bookStore.isStringContained(letter));

    }

}
