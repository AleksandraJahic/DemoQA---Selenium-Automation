package Tests.LogInAndOutTests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserCanLogOut extends BaseTest {
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
