package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Action_03 {
    WebDriver driver;
    Actions actions;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    //Testcase
    @Test
    public void TC_01_Drag_And_Drop_HTML4() throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement sourceCirle = driver.findElement(By.id("draggable"));
        WebElement targetCircle = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(sourceCirle, targetCircle).perform();
        Thread.sleep(3000);

        Assert.assertEquals(targetCircle.getText(), "You did great!");
        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toLowerCase(), "#03a9f4");

    }

    @Test
    public void TC_02_Drag_And_Drop_HTML5() throws InterruptedException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(columnA, columnB).perform();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");
    }

    @Test
    public void TC_03_scroll_element() throws InterruptedException {
        driver.get("http://live.techpanda.org/index.php/about-magento-demo-store/");
        actions.scrollToElement(driver.findElement(By.cssSelector("input#newsletter"))).perform();
        Thread.sleep(3000);
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
