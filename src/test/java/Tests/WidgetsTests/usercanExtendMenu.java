package Tests.WidgetsTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class usercanExtendMenu extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        navigateToWidgets();
        sideBar.clickOnSubMenuItem("Accordian");

        WebElement element3 = driver.findElement(By.cssSelector("#section2Heading"));
       scrollToElement(element3);
    }

    @Test
    public void userCanExtendMenu() {
        int menuItem = 2;
        accordianPage.clickOnAccordianMenu(menuItem);

        //Proveravam da li je body uopste prikazan
        Assert.assertTrue(accordianPage.getCurrentlyOpenedBody().isDisplayed());

        //Proveravam da li se za otvoreni menu-item header otvorio i body na istom indexu
        Assert.assertTrue(accordianPage.checkBody(menuItem).isDisplayed());

        //Proveravam da li je samo jedan body otvoren
       int expectedResult=1;
       Assert.assertEquals(accordianPage.howManyVisibleBodies(), expectedResult);
    }

    @Test
    public void whenUserOpensOneMenuAnotherCollapses() {
        int menuItem = 2;
        accordianPage.clickOnAccordianMenu(menuItem);
        accordianPage.clickOnAccordianMenu(1);

        //Proveravam da li je body uopste prikazan
        Assert.assertTrue(accordianPage.getCurrentlyOpenedBody().isDisplayed());

        //Proveravam da li se za otvoreni menu-item header otvorio i body na istom indexu
        Assert.assertTrue(accordianPage.checkBody(1).isDisplayed());

        //Proveravam da li je samo jedan body otvoren
        int expectedResult=1;
        Assert.assertEquals(accordianPage.howManyVisibleBodies(), expectedResult);

        //Proveravam da li je body koji smo zatvorili skriven
        Assert.assertTrue(accordianPage.isBodyCollapsed(2));
    }

    @Test
    public void userCanCollapseMenu() throws InterruptedException {
        int menuItem = 2;
        accordianPage.clickOnAccordianMenu(menuItem);
        Thread.sleep(5000);
        accordianPage.clickOnAccordianMenu(menuItem);


        //proveravam da je body na koji sam kliknula sada collapsed
        Assert.assertTrue(accordianPage.isBodyCollapsed(2));

        //proveravam da nijedan body nije prikazan
        int expectedResult=0;
        Assert.assertEquals(accordianPage.howManyVisibleBodies(), expectedResult);




    }
}




