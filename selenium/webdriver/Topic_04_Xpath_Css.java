package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Xpath_Css {
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
    public void Register_O1_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();


        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void Register_O2_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Quang Hoang");
        driver.findElement(By.id("txtEmail")).sendKeys("123123");
        driver.findElement(By.id("txtCEmail")).sendKeys("1231234");
        driver.findElement(By.id("txtPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtCPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtPhone")).sendKeys("0902366775");
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }
    @Test
    public void Register_O3_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Quang Hoang");
        driver.findElement(By.id("txtEmail")).sendKeys("1231@232");
        driver.findElement(By.id("txtCEmail")).sendKeys("12312343");
        driver.findElement(By.id("txtPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtCPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtPhone")).sendKeys("0902366775");
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }
    @Test
    public void Register_O4_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Quang Hoang");
        driver.findElement(By.id("txtEmail")).sendKeys("1231@232");
        driver.findElement(By.id("txtCEmail")).sendKeys("1231@232");
        driver.findElement(By.id("txtPassword")).sendKeys("quan");
        driver.findElement(By.id("txtCPassword")).sendKeys("quan");
        driver.findElement(By.id("txtPhone")).sendKeys("0902366775");
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void Register_O5_Invalid_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Quang Hoang");
        driver.findElement(By.id("txtEmail")).sendKeys("1231@232");
        driver.findElement(By.id("txtCEmail")).sendKeys("1231@232");
        driver.findElement(By.id("txtPassword")).sendKeys("quanghoang01");
        driver.findElement(By.id("txtCPassword")).sendKeys("quanghoang");
        driver.findElement(By.id("txtPhone")).sendKeys("0902366775");
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void Register_O6_Invalid_Phone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Quang Hoang");
        driver.findElement(By.id("txtEmail")).sendKeys("123@123");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtCPassword")).sendKeys("quanghoang@1");
        driver.findElement(By.id("txtPhone")).sendKeys("09023");
        driver.findElement(By.xpath("//button[text() = 'ĐĂNG KÝ' and  @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0902334234534534");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("014545454345345");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
