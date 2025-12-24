package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccordianPage {
    WebDriver driver;


    public AccordianPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCardHeaders() {
        return driver.findElements(By.cssSelector(".card-header"));
    }

    public List<WebElement> getAllCardBodies() {
        return driver.findElements(By.cssSelector(".accordion .card .collapse .card-body"));
    }

    //Hvatam parenta kako bih proverila kasnije da li je odredjeni body prikazan
    public List<WebElement> getCollapseWrapper() {
        return driver.findElements(By.cssSelector(".accordion .card .collapse"));
    }

    //Hvatam body koji ima klasu show (samo body koji ima tu klasu je otvoren (klasa se automatski dodeljuje bodiju kada se otvori header)
    public WebElement getCurrentlyOpenedBody() {
        return driver.findElement(By.cssSelector(".accordion .collapse.show .card-body"));
    }

    public List<WebElement> getAllOpenedBodies() {
        return driver.findElements(By.cssSelector(".accordion .collapse.show .card-body"));
    }
    //-----------------

    //Otvaram jedan od headera iz accordiona
    public void clickOnAccordianMenu(int menuItem) {
        int index = menuItem - 1;
        getCardHeaders().get(index).click();
    }


    //Hvatam body element na odredjenom indexu
    public WebElement checkBody(int menuItem) {
        int index = menuItem - 1;
        return getAllCardBodies().get(index);
    }

    //Pravim listu od vidljivih bodija i proveravam koliko ih ima - treba da bude samo jedan element u listi, onaj koji sadrzi i klasu show
    public int howManyVisibleBodies() {
        return getAllOpenedBodies().size();
    }

    //Proveravam da li je body na odredjenom indexu skriven
    public boolean isBodyCollapsed(int menuItem) {
        int index = menuItem - 1;
        WebElement specificbody= getCollapseWrapper().get(index);
        if (specificbody.getAttribute("class").contains("show")) {
            return false;
        }
        return true;
    }



}
