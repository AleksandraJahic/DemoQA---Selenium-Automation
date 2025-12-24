package Tests.LogInAndOutTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInWithValidCredentials extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

      navigateToLoginPage();

    }

    @Test
    public void userCanLogIn() {
        String username = excelReader.getStringData("Credentials", 1, 1);
        String password = excelReader.getStringData("Credentials", 1, 2);

        logInPage.fillInUsername(username);
        logInPage.fillInUPassword(password);

        WebElement element = driver.findElement(By.id("login"));
        scrollToElement(element);

        logInPage.clickOnLogIn();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("submit"))));

        String expectedURL = "https://demoqa.com/profile";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(profilePage.buttonIsDisplayed("Log out"));
        Assert.assertTrue(profilePage.getProfileUsername().isDisplayed());

    }
}
