package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class Topic_13_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;
    By resultText = By.cssSelector("p#result");

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");


    }
    @Test
    public void TC_02_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        String text = "selenium testing";
        alert.sendKeys(text);
        alert.accept();
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: " + text);
    }

    @Test
    public void TC_04_Authencation_Alert() {
        // Cách 1: chạy trên window (autoIT)
        String userName = "admin";
        String password = "admin";
        driver.get("http://the-internet.herokuapp.com/");
        // xem video để tự làm nếu gặp
        // có 2 cách, cách 1 truyền thằng URL và cách 2 download và sử dụng autoIT
        String authenLinkUrl = driver.findElement(By.xpath("//a[text() = 'Basic Auth']")).getAttribute("href");
        String[] authenArray = authenLinkUrl.split("//");
        System.out.println(authenArray[0]);
        System.out.println(authenArray[1]);

        driver.get(authenArray[0] + "//" + userName + ":" + password + "@" + authenArray[1]);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());

    }

    @Test
    public void TC_05_Authencation_Alert_Selenium_4x() {
        driver.get("http://the-internet.herokuapp.com/basic_auth");

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        }
        catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
    }
}
