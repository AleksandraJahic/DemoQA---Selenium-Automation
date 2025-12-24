package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;
    List<WebElement> cardBoxMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCardBoxMenu() {
        return driver.findElements(By.className("card-body"));
    }


    //-----------------------------------------------

    public void clickOnCardBox (String cardName) {
        for (int i=0; i<getCardBoxMenu().size(); i++) {
            if (getCardBoxMenu().get(i).getText().equalsIgnoreCase(cardName)) {
                getCardBoxMenu().get(i).click();
                break;
            }
        }
    }
}
