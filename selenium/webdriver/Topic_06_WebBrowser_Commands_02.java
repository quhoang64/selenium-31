package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_06_WebBrowser_Commands_02 {

    WebDriver driver;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        // Muốn dùng đc thì phải khởi tạo
        // Nếu ko khởi tạo sẽ gặp lỗi: NullPointerException
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Url() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
    @Test
    public void TC_03_Page_Navigation() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }
    @Test
    public void TC_04_Page_Source() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

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
