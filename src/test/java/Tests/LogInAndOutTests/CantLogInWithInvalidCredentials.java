package Tests.LogInAndOutTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CantLogInWithInvalidCredentials extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
       navigateToLoginPage();
    }

    @Test
    public void cantLogInWithValidUsernameInvalidPassword() {
        String username = excelReader.getStringData("Credentials", 2, 1);
        String password = excelReader.getStringData("Credentials", 2, 2);

        logInPage.fillInUsername(username);
        logInPage.fillInUPassword(password);
        WebElement element = driver.findElement(By.id("login"));
        scrollToElement(element);

        logInPage.clickOnLogIn();

        String expectedURL = "https://demoqa.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(logInPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(logInPage.getLogInButton().isDisplayed());
    }

    @Test
    public void cantLogInWithInvalidUsernameAndInvalidPassword() {
        String username = excelReader.getStringData("Credentials", 3, 1);
        String password = excelReader.getStringData("Credentials", 3, 2);

        logInPage.fillInUsername(username);
        logInPage.fillInUPassword(password);
        WebElement element = driver.findElement(By.id("login"));
        scrollToElement(element);

        logInPage.clickOnLogIn();
        String expectedURL = "https://demoqa.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(logInPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(logInPage.getLogInButton().isDisplayed());
    }

    @Test
    public void cantLogInWithInvalidUsernameAndValidPassword() {
        String username = excelReader.getStringData("Credentials", 4, 1);
        String password = excelReader.getStringData("Credentials", 4, 2);

        logInPage.fillInUsername(username);
        logInPage.fillInUPassword(password);
        WebElement element = driver.findElement(By.id("login"));
        scrollToElement(element);

        logInPage.clickOnLogIn();
        String expectedURL = "https://demoqa.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(logInPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(logInPage.getLogInButton().isDisplayed());

    }
}
