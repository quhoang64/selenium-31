package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_Wait_02_Find_Element {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//
//        fluentWait = new FluentWait<>(driver);
//        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
    }
    //Testcase
    @Test
    public void TC_01_Find_Element() {
        // Case 1 - Element dc tim thay trong khoang thoi gian dc set
        // Se ko can cho het time out
        // Tim thay tra ve 1 Web element

        // Case 2 - Nhieu Element dc tim thay trong khoang dc set
        // Se ko can cho het time out
        // Tim thay tra ve 1 Web element
        // Lay node dau tien de action cho du co ca n node

        // Case 3 - Element ko dc tim thay
        // Cho het timeout la 10s
        // Trong thoi gian 10s nay cu moi nua s se tim lai 1 lan
        // Nếu tim lai ma thay thi cung tra ve element roi qua step tiep theo
        // Neu tim lai ma ko thay thi danh fail testcase va throw exception: NoSuchElementException

    }
    @Test
    public void TC_02_Find_Elements() {

        // Case 3 - Element ko dc tim thay
        // Cho het timeout la 10s
        // Trong thoi gian 10s nay cu moi nua s se tim lai 1 lan
        // Nếu tim lai ma thay thi cung tra ve element roi qua step tiep theo
        // Neu tim lai ma ko thay thi tra ve List rong (empty) va ko danh fail testcase
        // Qua step tiep theo
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
