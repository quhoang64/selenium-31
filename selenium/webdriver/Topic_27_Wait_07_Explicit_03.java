package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_07_Explicit_03 {
    WebDriver driver;
    WebDriverWait explicitWait;

    String projectPath = System.getProperty("user.dir");
    String image1 = "images1.jpg";
    String image2 = "images2.jpg";
    String image3 = "images3.jpg";

    String image1Path = projectPath + "\\uploadFiles\\" + image1;
    String image2Path = projectPath + "\\uploadFiles\\" + image2;
    String image3Path = projectPath + "\\uploadFiles\\" + image3;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Ajaxloading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        By elementSelectDate = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");
        driver.findElement(By.xpath("//a[text() = '17']")).click();
        Assert.assertEquals(driver.findElement(elementSelectDate).getText(), "No Selected Dates to display.");

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(elementSelectDate).getText(), "Thursday, October 17, 2024");

    }

    @Test
    public void TC_02_Upload_file() {
        driver.get("https://gofile.io/uploadFiles");
        // Wait + Verify Spinner icon bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()= 'Add files']"))).click();

        // Wait + Verify Spinner icon bien mat
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border"))));

        driver.findElement(By.cssSelector("input#filesUploadInput")).sendKeys(image1Path + "\n" + image2Path + "\n" + image3Path);

        // Wait + Verify Spinner icon bien mat
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border"))));

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress-bar")))));

        //
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        // Verify button Download co tai tung hinh upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()= '"+image1+"']/ancestor::div[contains(@class, 'text-md-start')]/following-sibling::div//span[text() = 'Download']"))).isDisplayed());
    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
