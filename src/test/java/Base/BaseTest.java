package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public SideBar sideBar;
    public BookStore bookStore;
    public LogInPage logInPage;
    public ProfilePage profilePage;
    public AccordianPage accordianPage;
    public TabsPage tabsPage;
    public ExcelReader excelReader;
    public WebDriverWait wait;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new HomePage(driver);
        sideBar = new SideBar(driver);
        bookStore = new BookStore(driver);
        logInPage = new LogInPage(driver);
        profilePage = new ProfilePage(driver);
        excelReader  = new ExcelReader("credentials.xlsx");
        accordianPage = new AccordianPage(driver);
        tabsPage = new TabsPage(driver);
    }

    //-----POMOCNE METODE--------//

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void removeBanner() {
        ((JavascriptExecutor) driver).executeScript("document.getElementById('fixedban').style.display='none';");
    }
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void navigateToLoginPage() {
        driver.navigate().to("https://demoqa.com/");
        removeBanner();

        WebElement element = driver.findElement(By.className("card-body"));
        scrollToElement(element);

        homePage.clickOnCardBox("Book Store Application");
        WebElement element2 = driver.findElement(By.cssSelector(".element-list.collapse.show"));
        scrollToElement(element2);

        sideBar.clickOnSubMenuItem("Login");
    }
    public void navigateToBookstore() {
        driver.navigate().to("https://demoqa.com/");
        removeBanner();

        WebElement element = driver.findElement(By.className("card-body"));
        scrollToElement(element);

        homePage.clickOnCardBox("Book Store Application");
        //sideBar.clickOnItemFromTheSideBarMenu("Book Store Application");
    }
    public void navigateToWidgets() {
        driver.navigate().to("https://demoqa.com/");
        WebElement element = driver.findElement(By.className("card-body"));
        scrollToElement(element);
        homePage.clickOnCardBox("Widgets");

        removeBanner();

        WebElement element2 = driver.findElement(By.cssSelector(".element-list.collapse.show"));
        scrollToElement(element2);

        sideBar.clickOnItemFromTheSideBarMenu("Widgets");

    }
    public void logInToBookstore() {
        String username = excelReader.getStringData("Credentials", 1, 1);
        String password = excelReader.getStringData("Credentials", 1, 2);

        logInPage.fillInUsername(username);
        logInPage.fillInUPassword(password);

        WebElement element = driver.findElement(By.id("login"));
        scrollToElement(element);

        logInPage.clickOnLogIn();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
