package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_TextArea {
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
    public void TC_01_Empty_Email_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void TC_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.id("email")).sendKeys("13323@123123.3434");
        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.id("email")).sendKeys("quhoang@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");

        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-advice")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Incorrect_Email_or_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.id("email")).sendKeys("automation345345@gmail.net");
        driver.findElement(By.id("pass")).sendKeys("123456789");
        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li/span")).getText(), "Invalid login or password.");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("email")).sendKeys("automation@gmail.net");
        driver.findElement(By.id("pass")).sendKeys("1234534346789");
        Assert.assertEquals(driver.findElement(By.xpath("//li/span")).getText(), "Invalid login or password.");
    }

    @Test
    public void TC_05_Login_Success() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String firstname = "Quang", lastname = "Hoang", email = getEmailAddress(), password ="123456789";
        String fullname = firstname + " " + lastname;


        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//p//strong")).getText(),"Hello, " +fullname + "!");

        String contactInfor = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div//following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfor.contains(firstname));
        Assert.assertTrue(contactInfor.contains(lastname));

        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(3);

        // Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p//strong")).getText(),"Hello, " +fullname + "!");

        // Verify account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastname);

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailAddress() {
        return "automationFc" + new Random().nextInt(999999) + "@gmail.com";
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
