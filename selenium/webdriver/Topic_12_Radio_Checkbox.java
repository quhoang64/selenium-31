package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Radio_Checkbox {
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
    public void TC_01_Default_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By rearSideCheckbox = By.xpath("//label[text() = 'Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text() = 'Dual-zone air conditioning']/preceding-sibling::span/input");

        checkToElement(rearSideCheckbox);

        checkToElement(dualZoneCheckbox);
        // Verify checkbox đã đc chọn
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        // Verify checkbox đã đc chọn
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());

        // Bỏ chọn 2 checkbox
        unCheckToElement(rearSideCheckbox);
        unCheckToElement(dualZoneCheckbox);

        // Verify checkbox đã bỏ chọn
        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());
        // Verify checkbox đã bỏ chọn
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

    }

    @Test
    public void TC_02_Telerik_Radiobutton() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By towPetroRdio = By.xpath("//label[text() ='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By towDieselRadio = By.xpath("//label[text() ='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        // Click chọn 1 trong 2
        checkToElement(towPetroRdio);
        // Verify
        Assert.assertTrue(driver.findElement(towPetroRdio).isSelected());
        Assert.assertFalse(driver.findElement(towDieselRadio).isSelected());

        checkToElement(towDieselRadio);
        // Verify
        Assert.assertFalse(driver.findElement(towPetroRdio).isSelected());
        Assert.assertTrue(driver.findElement(towDieselRadio).isSelected());

    }

    @Test
    public void TC_03_Select_All_Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("div.form-input-wide input[type='checkbox']"));

        // Chọn hết tất cả các checkbox trong màn hình đó
        for (WebElement checkbox : allCheckbox){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
        // Verify hết tất cả checkbox
        for (WebElement checkbox : allCheckbox){
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        // chọn 1 checkbox / radio nào ó trong tất cả các checkbox/ radio
        allCheckbox = driver.findElements(By.cssSelector("div.form-input-wide input[type='checkbox']"));
        for (WebElement checkbox : allCheckbox){
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(2);
            }
        }
        for (WebElement checkbox : allCheckbox){
            if(checkbox.getAttribute("value").equals("Heart Attack")){
                Assert.assertTrue(checkbox.isSelected());
            }else {
                Assert.assertFalse(checkbox.isSelected());
            }

        }
    }

    @Test
    public void TC_04_Custom_Checkbox() {

        driver.get("https://log in.ubuntu.com/");
//        // Case 1: cách 1 -> khó maintain
//        driver.findElement(By.xpath("//span[text()='I don’t have an Ubuntu One account']/parent::label")).click();
//        sleepInSeconds(3);
//        Assert.assertTrue(driver.findElement(By.cssSelector("input#id_new_user")).isSelected());
        // Case 2: dùng thẻ input để click vs verify luôn
        // dùng javascript để click
        // chỉ cần 1 locator
        By userItentionRadio = By.cssSelector("input#id_new_user");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(userItentionRadio));
        Assert.assertTrue(driver.findElement(userItentionRadio).isSelected());

        // interface Webdriver
        // Interface JavascriptExecutor
        // Ep kiểu interface qua kiểu interface khác

    }

    @Test
    public void TC_06_Custom_Radio_GGForm(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By radioButtonCanThO = By.xpath("//div[@aria-label='Cần Thơ']");
        By quangNamCheckbox = By.xpath("//div[@aria-label='Quảng Nam']");
        // Cách 1
        Assert.assertEquals(driver.findElement(radioButtonCanThO).getAttribute("aria-checked"), "false");
        // Cách 2
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        driver.findElement(radioButtonCanThO).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(radioButtonCanThO).getAttribute("aria-checked"), "true");

        driver.findElement(quangNamCheckbox).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(quangNamCheckbox).getAttribute("aria-checked"), "true");

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

    public void checkToElement(By byXpath){
        if (!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(3);
        }
    }
    public void unCheckToElement(By byXpath){
        if (driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(3);
        }
    }
}
