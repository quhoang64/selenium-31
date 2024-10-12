package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;


import java.time.Duration;

public class Topic_11_Button {
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
    public void TC_01_Ego_Button() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        Assert.assertFalse(registerButton.isEnabled());
        driver.findElement(By.cssSelector("input#chinhSach")).click();
        Assert.assertTrue(registerButton.isEnabled());

        // Lấy ra mã màu nền của button
        String registerButtonColorRGB = registerButton.getCssValue("background-color");
        System.out.println(registerButtonColorRGB);
        Color registerButtonBackgroudColor = Color.fromString(registerButtonColorRGB);
        String registerBackgroundHexa = registerButtonBackgroudColor.asHex();
        System.out.println(registerBackgroundHexa);
        Assert.assertEquals(registerBackgroundHexa.toLowerCase(), "#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify login button disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify màu button
        System.out.println(loginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        // Nhập email/ pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("quang@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        // Verify login button enable
        Assert.assertTrue(loginButton.isEnabled());
        // Verify màu button
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");


    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
