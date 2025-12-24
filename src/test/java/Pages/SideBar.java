package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBar {
    WebDriver driver;
    List<WebElement> sideBarMenuItems;
    List<WebElement> SubMenu;


    public SideBar(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSideBarMenuItems() {
        return driver.findElements(By.className("element-group"));
    }


    public List<WebElement> getSubMenu() {
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }

    //-----------------------------------------------
    public void clickOnItemFromTheSideBarMenu(String itemName) {
        for (int i = 0; i<getSideBarMenuItems().size(); i++) {
            if (getSideBarMenuItems().get(i).getText().equalsIgnoreCase(itemName)) {
                getSideBarMenuItems().get(i).click();
                break;
            }
        }
    }

    public void clickOnSubMenuItem(String itemName) {
        for (int i = 0; i<getSubMenu().size(); i++) {
            if (getSubMenu().get(i).getText().equalsIgnoreCase(itemName)) {
                getSubMenu().get(i).click();
                break;
            }
        }
    }

}
