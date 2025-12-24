package Tests.WidgetsTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userCanNavigateTabs extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        navigateToWidgets();
        WebElement toolTips = driver.findElement(By.cssSelector("#item-6"));//element ispod mog
        scrollToElement(toolTips);
    }

    @Test
    public void userCanOpenTabsMenu() {

        sideBar.clickOnSubMenuItem("Tabs");

        WebElement element3 = driver.findElement(By.cssSelector("#tabsContainer"));
        scrollToElement(element3);

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/tabs");
        String expectedPageHeadline = "Tabs";
        Assert.assertEquals(tabsPage.getPageHeadline(), expectedPageHeadline);
        Assert.assertTrue(tabsPage.getWhatTabContent().isDisplayed());
    }

    @Test
    public void userCanOpenUseTab() {
        sideBar.clickOnSubMenuItem("Tabs");
        WebElement element3 = driver.findElement(By.cssSelector("#tabsContainer"));
        scrollToElement(element3);

        tabsPage.clickOnUseTab();
        waitForVisibility(tabsPage.getUseTabContent());

        Assert.assertTrue(tabsPage.getUseTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getWhatTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getMoreTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getOriginTabContent().isDisplayed());

    }

    @Test
    public void userCanNavigateBackToWhatTab() {
        sideBar.clickOnSubMenuItem("Tabs");
        WebElement element3 = driver.findElement(By.cssSelector("#tabsContainer"));
        scrollToElement(element3);

        tabsPage.clickOnUseTab();
        tabsPage.clickOnWhatTab();
        waitForVisibility(tabsPage.getWhatTabContent());

        Assert.assertTrue(tabsPage.getWhatTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getMoreTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getOriginTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getUseTabContent().isDisplayed());

    }

    @Test
    public void userCanOpenOriginTab() {
        sideBar.clickOnSubMenuItem("Tabs");
        WebElement element3 = driver.findElement(By.cssSelector("#tabsContainer"));
        scrollToElement(element3);

        tabsPage.clickOnOriginTab();
        waitForVisibility(tabsPage.getOriginTabContent());

        Assert.assertTrue(tabsPage.getOriginTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getWhatTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getMoreTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getUseTabContent().isDisplayed());
    }

    //-------------PRONADJEN BUG-------------------------------//
    //MORE tab i content postoje u html strukturi ali tab nije klikabilan, zato test pada (u suprotnom bi radio)
    //Napisati Bug report
    @Test
    public void userCanOpenMoreTab() {
        sideBar.clickOnSubMenuItem("Tabs");
        WebElement element3 = driver.findElement(By.cssSelector("#tabsContainer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element3);

        tabsPage.clickOnMoreTab();

        Assert.assertTrue(tabsPage.getMoreTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getWhatTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getOriginTabContent().isDisplayed());
        Assert.assertFalse(tabsPage.getUseTabContent().isDisplayed());
    }
}
