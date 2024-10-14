package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Action_02 {
    WebDriver driver;
    Actions action;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }
    //Testcase
    @Test
    public void TC_01_Click_And_Hold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol.ui-selectable>li"));
        action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(3)).release().perform();

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol.ui-selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 4);

    }

    @Test
    public void TC_02_Click_And_Hold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol.ui-selectable>li"));

        // Nhấn phím Ctrl xuống (chưa nhả ra)
        action.keyDown(Keys.CONTROL).perform();
        action.click(allNumber.get(0)).click(allNumber.get(3)).click(allNumber.get(5)).perform();
        action.keyUp(Keys.CONTROL).perform();

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol.ui-selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 3);
    }

    @Test
    public void TC_03_DoubleClick() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        action.doubleClick(driver.findElement(By.xpath("//button[text() = 'Double click me']"))).perform();
        Thread.sleep(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_04_RightClick() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        // Click chuột phải vào button
        By quitContextBy = By.cssSelector("li.context-menu-icon-quit");
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed());

        // Hover mouse
        action.moveToElement(driver.findElement(quitContextBy)).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click quit
        action.click(driver.findElement(quitContextBy)).perform();
        driver.switchTo().alert().accept();
        Assert.assertFalse(driver.findElement(quitContextBy).isDisplayed());


    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
