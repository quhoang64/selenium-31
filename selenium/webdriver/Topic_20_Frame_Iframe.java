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

public class Topic_20_Frame_Iframe {
    WebDriver driver;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Form_Site() {
        // Trang A - domain: formasite.com
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        sleepInSeconds(5);
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        WebElement iframeLocator = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(iframeLocator.isDisplayed());
        // Chứa iframe - Trang B
        // Tu A vao B
        driver.switchTo().frame("frame-one85593366");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        sleepInSeconds(3);

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

//        // tu B vao C
//        driver.switchTo().frame("frame-one85593366");
//        // Tu C ve B
//        driver.switchTo().parentFrame();
//        // Tu B quay lai A
//        driver.switchTo().defaultContent();
    }

    @Test
    public void TC_02_toi_di_code_dao() {
        driver.get("https://toidicodedao.com/");
        sleepInSeconds(5);
        driver.switchTo().frame(driver.findElement(By.xpath("//div/span/iframe")));
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()= 'Tôi đi code dạo']/parent::div/following-sibling::div")).getText(), "406,390 followers");
    }

    @Test
    public void TC_03_Frame_HD_Bank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        sleepInSeconds(3);
        driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("quang_hoang");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(3);
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("1234567");
        sleepInSeconds(3);


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
