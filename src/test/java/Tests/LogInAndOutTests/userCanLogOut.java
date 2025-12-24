package Tests.LogInAndOutTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userCanLogOut extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        navigateToLoginPage();
        logInToBookstore();

    }

    @Test
    public void userCanLogOut() {
        profilePage.clickOnLogOut("Log out");
        waitForVisibility(logInPage.getLogInButton());


        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        Assert.assertTrue(logInPage.getLogInButton().isDisplayed());
        Assert.assertTrue(logInPage.getNewUserButton().isDisplayed());

    }
}
