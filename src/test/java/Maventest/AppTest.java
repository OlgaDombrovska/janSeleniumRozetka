package Maventest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppTest {

    private FirefoxDriver driver;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {

        driver.get("http://rozetka.com.ua/");
        driver.findElementByClassName("header-search-input-text").sendKeys("eerere");
        driver.findElementByClassName("btn-link-i").click();
        String actualResult = driver.findElementByClassName("search-result-title-nothing-text").getText();
        String expectedResult = "По запросу";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test2() {
        driver.get("http://rozetka.com.ua/");
        driver.findElementByClassName("header-search-input-text").sendKeys("iPhone 6s Plus 16GB Space Gray");
        driver.findElementByClassName("btn-link-i").click();
        String actualResult = driver.findElementByClassName("g-i-list-title").getText();
        String expectedResult = "Apple" + " " + "iPhone" + " " + "6s" + " " + "Plus" + " " + "16GB" + " " + "Space" + " " + "Gray";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test3() {
        driver.get("http://rozetka.com.ua/");
        driver.findElementByClassName("header-search-input-text").sendKeys("iPhone 6s Plus 16GB Space Gray");
        driver.findElementByClassName("btn-link-i").click();
        driver.findElementByName("topurchases").click();
        String actualResult = driver.findElementByClassName("cart-title").getText();
        String expectedResult = "Вы";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @After
    public void postCondition() {
        driver.close();
    }
}