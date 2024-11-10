package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_01_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    By email = By.cssSelector("input#email");

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/r.php");
    }
    //Testcase
    @Test
    public void TC_01_Visible() {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(email));

        Assert.assertTrue(driver.findElement(email).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_In_Dom() {
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(email));
        Assert.assertFalse(driver.findElement(email).isDisplayed());
    }

    @Test
    public void TC_03_Presence() {
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(email));
    }

    @Test
    public void TC_04_Stale() {

        WebElement reconfirm = driver.findElement(email);
        driver.findElement(email).click();
        // K hiển thị trên UI vs HTML
        // Staleness dùng trong case trước do element co hien tren DOM nhưng sau khi tắt popup thi element mat trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(email)));
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
