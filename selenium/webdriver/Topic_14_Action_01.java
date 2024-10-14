package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Action_01 {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Set browser tại ví trí 0x0
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    //Testcase
    @Test
    public void TC_01_Hover() throws InterruptedException {
        // khi chạy các testcase có liên quan đến action thì ko đc dùng chuột/ bàn phím cùng lúc
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));
        action.moveToElement(ageTextbox).perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_myncha() throws InterruptedException {
        driver.get("https://www.myntra.com/");
        action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text() = 'Kids']"))).perform();
        Thread.sleep(2000);
        // Action click
        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text() = 'Home & Bath']"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb' and text() = 'Kids Home Bath']")).getText(), "Kids Home Bath");
    }

    @Test
    public void TC_03_Hover_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@title='Hành Trang Đến Trường']/span[text() ='Hành Trang Đến Trường']"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text() ='Luyện Thi Môn Toán']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text() = 'Toán']")).isDisplayed());

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
