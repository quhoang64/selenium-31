package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_29_Wait_08_Mixing_Implicit_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Mix_Implicit_Explicit() {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void TC_02() {

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
