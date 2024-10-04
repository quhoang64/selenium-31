package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //Testcase
    @Test
    public void TC_01_ID() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.id("search")).sendKeys("SamSung");
        driver.findElement(By.id("firstname")).sendKeys("Quang Hoang");
    }


    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-language-background"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("q"));
    }

    @Test
    public void TC_04_Link() {
        // Truyền hết chuỗi text vào
        driver.findElement(By.linkText("ABOUT US"));
    }

    @Test
    public void TC_05_Partial_Link() {
        driver.findElement(By.partialLinkText("http://live.techpanda.org/index.php/about-magento-demo-store/"));

    }

    @Test
    public void TC_06_Tagname() {
        // Tìm nhiều element giống nhau
        int linkNumber = driver.findElements(By.tagName("a")).size();
        System.out.println("Tổng số link a:" + linkNumber );

        // Tagname giống nhau nhưng element khác nhau thì dùng cách tìm css
    }

    @Test
    public void TC_07_Css() {
        int checkboxNumber = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println("Tong so luong checkbox:" + checkboxNumber);


        // ccs vs id
        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));
        // css vs class
        driver.findElement(By.cssSelector("div[class='header-language-background']"));
        driver.findElement(By.cssSelector("div.header-language-background"));
        // ngoại le
        driver.findElement(By.cssSelector("input.input-text.required-entry"));
        // css vs name
        driver.findElement(By.cssSelector("input[name='q']"));
        // css vs link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));

        //css vs link
            // đoạn cuối dấu $
        driver.findElement(By.cssSelector("a[href$='about-magento-demo-store/']"));
            // đoạn đầu dấu ^
        driver.findElement(By.cssSelector("a[href^='http://live.techpanda.org/index.php']"));
            // đoạn giữa dấu *
        driver.findElement(By.cssSelector("a[href*='org/index.php/about-magento']"));
    }

    @Test
    public void TC_08_Xpath() {
        //Xpath vs ID
        driver.findElement(By.xpath("//input[@id='search']"));
        //Xpath vs Class
        driver.findElement(By.xpath("//input[@class='input-text']"));
        //Xpath vs Name
        driver.findElement(By.xpath("//input[@name='firstname']"));
        //Xpath vs Link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));
        driver.findElement(By.xpath("//a[text()= 'About Us']"));
        //Xpath vs partial Link
        driver.findElement(By.xpath("//a[start-with(@href='http://live.techpanda.org/index.php')]"));
        driver.findElement(By.xpath("//a[contains(@href, 'about-magento-demo-store/')]"));

        // Xpath vs Tagname

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
