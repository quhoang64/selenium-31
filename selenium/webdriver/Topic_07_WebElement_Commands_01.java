package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_01 {
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
    public void TC_01_Element() {
        // HTML element: textbox/ text area/ link/ icon/ button/...
        // Tìm và trả về 1 element  (chưa tương tác lên)
        driver.findElement(By.id(""));

        // Tìm và tương các lên
        driver.findElement(By.id("")).click();
        // dùng để nhập liệu các field
        driver.findElement(By.id("")).sendKeys();

        // Dùng để verify 1 checkbox/ radio/ dropdown đã đc chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dùng để verify 1 element bất kì có hiển thị hay k
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        // Dung để verify 1 element có đc thao tác lên hay ko ( ko phải read only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML element
        driver.findElement(By.id("")).getAttribute("title");

        //
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomProperty("title");
        driver.findElement(By.id("")).getDomAttribute("title");

        // thường dùng để verify mã màu, font/ size
        // tab styles trong elements
        driver.findElement(By.id("")).getCssValue("title");

        // vị trí của element so vs độ phân giải màn hình
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();

        // Location + Size
        driver.findElement(By.id("")).getRect();

        //Shadow Element
        driver.findElement(By.id("")).getShadowRoot();

        // Từ id/class/name/css/ xpath có thể truy ra ngược lại tagname HTML
        driver.findElement(By.id("")).getTagName();

        driver.findElement(By.id("")).getText();

        // Form (element nào là thẻ form hoặc nằm trong thẻ form
        // Hành vi giông enter
        // Register/ Login/ Search,...



        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
        // Khi có dùng biến này ít nhất từ 2 lan trở lên
        WebElement fullnameTextbox = driver.findElement(By.id(""));
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
