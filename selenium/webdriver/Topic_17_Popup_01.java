package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Popup_01 {
    WebDriver driver;
    WebDriverWait explicitWait;


    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Fixed_Popup_InDom() {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//button[text()= 'Đăng nhập']")).click();
        sleepInSeconds(3);
        By loginPopup = By.cssSelector("div.MuiDialog-paper");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // kiem tra popup login hien thi
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        //
        driver.findElement(By.cssSelector("input[placeholder= 'Tài khoản đăng nhập']")).sendKeys("automationFC");
        driver.findElement(By.cssSelector("input[placeholder= 'Mật khẩu']")).sendKeys("automationFC");
        driver.findElement(By.xpath("//button[text()= 'Đăng nhập' and @type='submit']")).click();
        sleepInSeconds(3);

//        Assert.assertEquals(driver.findElement(By.cssSelector("div.SnackbarItem-message")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        // Close popup
        driver.findElement(By.cssSelector("button.close-btn")).click();

        // Kiem tra login khong hien thi
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }

    @Test
    public void TC_02_Fixed_Popup_InDom2() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(2);
        // Ktra hien thi
        Assert.assertTrue(driver.findElement(By.cssSelector("div.modal-content div.k-popup-account-mb-content")).isDisplayed());
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationFC@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("automationFC");

        Assert.assertEquals(driver.findElement(By.id("password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_Dom_3() {
        driver.get("https://tiki.vn/");
        driver.findElement(By.cssSelector("img[alt='close-icon']")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.styles__Root-sc-2hr4xa-0.jyAQAr")).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("automationFC@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("automationFC");
        driver.findElement(By.xpath("//button[text() = 'Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span.error-mess")).getText(), "Thông tin đăng nhập không đúng");
        sleepInSeconds(3);
        //Close popup
        driver.findElement(By.cssSelector("img.close-img")).click();
        sleepInSeconds(3);

        // Khi đóng popup th HTML k còn trong DOM nua
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.styles__Root-sc-2hr4xa-0.jyAQAr")).size(), 0);
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_Dom_4() {
        driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");
        driver.findElement(By.xpath("//a[text()= 'Sign up for Facebook']")).click();
        sleepInSeconds(2);
        // khong lam dc vi facebook khong co de popup register
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
