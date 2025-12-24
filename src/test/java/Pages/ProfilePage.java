package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getButtonList() {
        return driver.findElements(By.id("submit"));
    }

    public WebElement getProfileUsername() {
        return driver.findElement(By.id("userName-value"));
    }

    public WebElement getGoToStoreButton() {
        return driver.findElement(By.id("gotoStore"));
    }

    //----------------------------------------------------
public boolean buttonIsDisplayed(String buttonName) {
    for (int i=0; i<getButtonList().size(); i++) {
        if (getButtonList().get(i).getText().equalsIgnoreCase(buttonName)) {
            return true;
        }
    } return false;
}

    public void clickOnLogOut(String buttonName) {
        for (int i=0; i<getButtonList().size(); i++) {
            if (getButtonList().get(i).getText().equalsIgnoreCase(buttonName)) {
                getButtonList().get(i).click();
                break;
            }
        }
    }
}
