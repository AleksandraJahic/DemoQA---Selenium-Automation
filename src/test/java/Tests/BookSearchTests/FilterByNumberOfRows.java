package Tests.BookSearchTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterByNumberOfRows extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        navigateToBookstore();
        scrollToElement(bookStore.getParent());
    }

    @Test
    public void selectNoOfRows() {
        String chooseRows = "20";
        bookStore.clickOnPageSizeOptions();
        scrollToElement(bookStore.getParent());
        bookStore.selectNumberOfRows(chooseRows);

        WebElement element2 = driver.findElement(By.cssSelector(".select-wrap.-pageSizeOptions"));
        scrollToElement(element2);

        String actualRows = String.valueOf(bookStore.countRows());
        String selectedText = bookStore.selectedRow();

        //Proveravam da li je broj redova na stranici jednak broju redova koji sam izabrala
        Assert.assertEquals(actualRows, chooseRows);

        //Proveravam da li je prikazan broj redova koji sam izabrala u samom dropdownu
        Assert.assertEquals(selectedText, (chooseRows+" rows"));
    }
}
