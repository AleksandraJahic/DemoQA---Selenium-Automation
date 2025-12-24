package Tests.BookSearchTests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userCanSearchBooksUsingSearchBox extends BaseTest {

    @BeforeMethod
    public void pageSetUp()  {
        navigateToBookstore();
    }

    @Test
    public void searchTheStoreWithFullTitle() {
    String bookTitle = excelReader.getStringData("BookTitles", 1, 0);

    bookStore.typeInSearchBox(bookTitle);
    bookStore.clickSearch();
    }

    @Test
    public void searchTheStoreWithAuthor() {
        String author = excelReader.getStringData("BookTitles", 4, 1);

        bookStore.typeInSearchBox(author);
        bookStore.clickSearch();
    }

    @Test
    public void partialSearch() {
        String name = excelReader.getStringData("BookTitles", 4, 1);
        String partOfTheName = name.substring(0,3); //substring - pretraga dela stringa, prvi broj je index odakle pocinjemo, drugi broj karaktera
        bookStore.typeInSearchBox(partOfTheName);
        bookStore.clickSearch();
    }
    @Test
    public void oneLetterSearch() {
        String letter = "b";
        bookStore.typeInSearchBox(letter);
        bookStore.clickSearch();
    }

}
