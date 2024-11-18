package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_31_Wait_10_Page_Ready {
    WebDriver driver;
    WebDriverWait explicitWait;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_nocommer() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        By selectedDateBy = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");
        Assert.assertEquals(driver.findElement(selectedDateBy).getText(), "No Selected Dates to display.");
        driver.findElement(By.xpath("//a[text()= '21']")).click();
        ///
        Assert.assertTrue(isPageLoadedSuccess());

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(), "Thursday, November 21, 2024");

    }

    @Test
    public void TC_02() {

    }

    public boolean waitAjaxloading(){
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Label1")));
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
        return explicitWait.until(jQueryLoad) ;
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
