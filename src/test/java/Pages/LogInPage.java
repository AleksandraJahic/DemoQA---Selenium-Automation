package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.id("login"));
    }

    public WebElement getNewUserButton() {
        return driver.findElement(By.id("newUser"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("name"));
    }
//----------------------------------------------

    public void fillInUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void fillInUPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickOnLogIn() {
        getLogInButton().click();
    }

}
