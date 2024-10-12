package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    String firstname = "Antony", lastname = "Long", emailAddress = getEmailAddress();
    String companyName = "apex", password = "123456";
    String day = "10", month = "11", year = "1999";


    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    //Testcase
    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstname);
        driver.findElement(By.cssSelector("a.ico-LastName")).sendKeys(lastname);

        // Day dropdown
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        // Chọn ngày
        day.selectByVisibleText(this.day);

        // Verify dropdown này là Single
        // Nếu nó la multiple: true
        // Nếu nó la single: false
        Assert.assertFalse(day.isMultiple());

        //Verify số lương item trong dropdown này là 32 item
        Assert.assertEquals(day.getOptions().size(), 32);



        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(this.month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(this.year);

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(3);

        // Verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastname);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), this.day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), this.month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), this.year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    public String getEmailAddress() {
        return "Antony" + new Random().nextInt(999999) + "@gmail.com";
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
