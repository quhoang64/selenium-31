package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Wait_09_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;
    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        fluentDriver = new FluentWait<>(driver);
//        // Time - Default Polling Time: 0.5s
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        // Time - Polling: 0.3s
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01() {
        driver.get("https://www.facebook.com/");

        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));

        fluentString = new FluentWait<String>("abc");

        // Tổng time
        fluentDriver.withTimeout(Duration.ofSeconds(10));
        // Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(200));

        // Ignore NoSuchElement exceptions
        fluentDriver.ignoring(NoSuchElementException.class);
        // Ignore TimeoutException
        fluentDriver.ignoring(TimeoutException.class);


        // Condition
        fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("")).getText();
            }
        });
    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();

        fluentDriver.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);

        fluentDriver.until(new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text() = 'Hello World!']")).isDisplayed();
            }
        });

        String helloText = fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text() = 'Hello World!']")).getText();
            }
        });

        Assert.assertEquals(helloText, "Hello World!");
    }

    @Test
    public void TC_03(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countdownTime = driver.findElement(By.id("javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countdownTime);

        fluentElement.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {

            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                return text.endsWith("00");
            }
        });
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
