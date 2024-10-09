package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_06_WebBrowser_Commands_01 {
    //Các câu lệnh để thao tác vs Browser đều có câu lệnh driver.

    WebDriver driver;


    // Các câu lệnh thao tác vs element có câu lệnh element.
    WebElement element;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        // Muốn dùng đc thì phải khởi tạo
        // Nếu ko khởi tạo sẽ gặp lỗi: NullPointerException
        driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }
    //Testcase
    @Test
    public void TC_01() {
        driver.get("https://www.facebook.com/");

        // 2 hàm này sẽ ảnh hưởng tới hàm implicitWait

        WebElement elemtents = driver.findElement(By.id("email"));

        List<WebElement> checkbox = driver.findElements(By.tagName("input"));
        // hàm get trả về 1 element, lấy trong mảng elements mới gọi phía trên
        checkbox.get(1).click();

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
