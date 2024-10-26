package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Topic_23_Upload_File {
    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(image1Path);
        sleepInSeconds(2);
        driver.findElement(uploadBy).sendKeys(image2Path);
        sleepInSeconds(2);
        driver.findElement(uploadBy).sendKeys(image3Path);
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image3 + "']")).isDisplayed());


        List<WebElement> startButtons = driver.findElements(By.cssSelector("td button.start"));
        for (WebElement startButton : startButtons) {
            startButton.click();
            sleepInSeconds(2);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image3 + "']")).isDisplayed());


    }

    @Test
    public void TC_02_Multiple_Files() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(image1Path + "\n" + image2Path + "\n" + image3Path);
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ image3 + "']")).isDisplayed());


        List<WebElement> startButtons = driver.findElements(By.cssSelector("td button.start"));
        for (WebElement startButton : startButtons) {
            startButton.click();
            sleepInSeconds(2);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text() = '"+ image3 + "']")).isDisplayed());
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
