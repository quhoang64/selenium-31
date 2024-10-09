package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    // Pre-condition
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //Testcase
    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#email")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#email")).sendKeys("quhoang@gmail.com");
            System.out.println("Email is displayed");
        } else {
            System.out.println("Email is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("checkbox is displayed");
        } else {
            System.out.println("checkbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("automation");
            System.out.println("Textarea is displayed");
        } else {
            System.out.println("Textarea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text() = 'Name: User5']")).isDisplayed()) {
            System.out.println("text is displayed");
        } else {
            System.out.println("text is not displayed");
        }

    }

    @Test
    public void TC_02_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#email")).isEnabled()) {
            System.out.println("Email is enable");
        } else {
            System.out.println("Email is not enabled");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Email is enable");
        } else {
            System.out.println("Email is not enabled");
        }
    }

    @Test
    public void TC_03_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());
    }

    @Test
    public void TC_04_emailchip() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("auto");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());


        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("AUTO");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@!##");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

    }



    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
