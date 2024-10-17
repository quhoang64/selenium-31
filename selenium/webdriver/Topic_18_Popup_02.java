package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Popup_02 {
    WebDriver driver;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Popup_Random_In_Dom() {
        driver.get("https://www.javacodegeeks.com/");
        sleepInSeconds(20);
        By newletterPopup = By.cssSelector("div#card");

        // Neu hien thi thi close no di
        // Luon chay đc vì element luôn co trong HTML/ DOM
        if (!driver.findElements(newletterPopup).isEmpty() && driver.findElements(newletterPopup).get(0).isDisplayed()){
            driver.findElement(By.xpath("//div[@style='cursor: pointer;']")).click();
            sleepInSeconds(2);
        }else { // Khong hien thi thi qua step tiep theo
            System.out.println("Popup k hien thi ");
        }

        // Nhap vao field search
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSeconds(5);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() ='Agile Testing Explained']")).isDisplayed());

    }

    @Test
    public void TC_02_Popup_Random_In_Dom() {
        driver.get("https://vnk.edu.vn/");
        By marketingPopup = By.cssSelector("div#popmake-39268");
        //
        if (driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("button.pum-close.popmake-close")).click();
            sleepInSeconds(2);
            System.out.println("Popup hien thi");
        }
        driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//strong[text()='Sử dụng mục lục để tra cứu nhanh khóa học bạn đang quan tâm!']")).getText(), "Sử dụng mục lục để tra cứu nhanh khóa học bạn đang quan tâm!");

    }

    @Test
    public void TC_03_Popup_Not_In_Dom() {
        driver.get("https://dehieu.vn/");
        By marketingPopup = By.cssSelector("div.modal-content.css-modal-bt");
        int height = driver.manage().window().getSize().getHeight();
        System.out.println(height);
        if (!driver.findElements(marketingPopup).isEmpty() && driver.findElements(marketingPopup).get(0).isDisplayed()){
            System.out.println("Popup hien thi");
            if (height < 1920){
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.cssSelector("button.close")));
            }else {
                driver.findElement(By.cssSelector("button.close")).click();

            }
            sleepInSeconds(3);
        }

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
