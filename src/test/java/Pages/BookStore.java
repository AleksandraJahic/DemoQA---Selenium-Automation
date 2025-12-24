package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookStore {
    WebDriver driver;

    public List<WebElement> getBookTitles() {
        return driver.findElements(By.cssSelector(".rt-td:nth-child(2)"));
    }
    public List<WebElement> getBookAuthors() {
        return driver.findElements(By.cssSelector(".rt-td:nth-child(3)"));
    }

    public BookStore(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id("basic-addon2"));
    }

    public WebElement getShowRows() {
        return driver.findElement(By.cssSelector(".select-wrap.-pageSizeOptions"));
    }


    public WebElement getParent() {
        return driver.findElement(By.cssSelector(".select-wrap.-pageSizeOptions"));
    }

    public List<WebElement> getOptions() {
        return getParent().findElements(By.tagName("option"));
    }


    public List<WebElement> getRows() {
        return driver.findElements(By.cssSelector(".rt-tr-group"));
    }

    public WebElement getOptionsContainer() {
        return getParent().findElement(By.cssSelector(".options"));
    }

    //-----------------------------------
    public void typeInSearchBox(String text) {
        getSearchBox().sendKeys(text);
    }

    public void clickSearch() {
        getSearchButton().click();
    }

    public void clickOnPageSizeOptions() {
        getShowRows().click();
    }

    public void selectNumberOfRows(String rowNumbers) {
        for (int i = 0; i < getOptions().size(); i++) {
            if (getOptions().get(i).getAttribute("value").equals(rowNumbers)) {
                getOptions().get(i).click();
                break;
            }
        }
    }

    public int countRows() {
        return getRows().size();
    }

    public String selectedRow() {
        Select select = new Select(driver.findElement(By.tagName("select")));
        return select.getFirstSelectedOption().getText();
    }


    public boolean isBookTitleDisplayed(String expectedTitle) {
        for (WebElement title : getBookTitles()) {
            if (title.getText().equalsIgnoreCase(expectedTitle)) {
                return true;
            }
        }
        return false;
    }


    public boolean isAuthorDisplayed(String expectedAuthor) {
        for (WebElement author : getBookAuthors()) {
            if (author.getText().equalsIgnoreCase(expectedAuthor)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStringContained(String partialName) {
        for (WebElement title : getBookTitles()) {
            if (title.getText().contains(partialName)) {
                return true;
            }
        }
        return false;
    }

}
