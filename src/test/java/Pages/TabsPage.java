package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabsPage {
    WebDriver driver;

    public TabsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTabsHeadline() {
        return driver.findElement(By.tagName("h1"));
    }

    public WebElement getWhatTab() {
        return driver.findElement(By.id("demo-tab-what"));
    }

    public WebElement getOriginTab() {
        return driver.findElement(By.id("demo-tab-origin"));
    }

    public WebElement getUseTab() {
        return driver.findElement(By.id("demo-tab-use"));
    }

    public WebElement getMoreTab() {
        return driver.findElement(By.id("demo-tab-more"));
    }

    public WebElement getWhatTabContent() {
        return driver.findElement(By.id("demo-tabpane-what"));
    }

    public WebElement getOriginTabContent() {
        return driver.findElement(By.id("demo-tabpane-origin"));
    }

    public WebElement getUseTabContent() {
        return driver.findElement(By.id("demo-tabpane-use"));
    }

    public WebElement getMoreTabContent() {
        return driver.findElement(By.id("demo-tabpane-more"));
    }

    public List<WebElement> getTabPanes() {
        return driver.findElements(By.className("tab-pane"));
    }

    //-----------------------
    public String getPageHeadline() {
        return getTabsHeadline().getText();
    }

    public void clickOnWhatTab() {
        getWhatTab().click();
    }
    public void clickOnOriginTab() {
        getOriginTab().click();
    }
    public void clickOnUseTab() {
        getUseTab().click();
    }
    public void clickOnMoreTab() {
        getMoreTab().click();
    }

}
