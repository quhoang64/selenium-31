package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;


    @Test
    public  void verifyTestNG(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        // Trong Java có nhiều thư viên để verify dữ liệu
        // Testing Framework (Unit/ Intergration/ UI Automation Test)

        // kiểu dữ liệu nhận vào là boolean
        // Khi mong muốn điều kiện trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        // Mong muốn điều kiện trả về là sai thì dùng assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Facebook helps you share with the people in your life."));

        // Các hàm trả về kiểu dữ liệu la boolean
        // Quy tắc: bất đầu vs tien tố là isXX
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // Mong đợi 1 điều kiện nó giống như thực tế
        // Actual = expected
        Assert.assertEquals(driver.findElement(By.id("")).getText(), "Facebook");

        // Unit test
        Object name = null;
        Assert.assertNull(name);
        name = "testing";
        Assert.assertNotNull(name);

    }
}
