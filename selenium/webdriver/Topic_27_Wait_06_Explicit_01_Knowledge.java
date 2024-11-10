package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_06_Explicit_01_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01() {
        // Cho 1 Alert presence tren HTML/DOM truoc khi thao tac len
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // chờ cho có trong DOM k quan tâm có trên UI
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //chờ cho 1 list element hiện trên DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //Chờ cho 1 -> n element đc hiển thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        // Cho cho 1 element dc phep click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Cho cho page co title nhu mong doi
        explicitWait.until(ExpectedConditions.titleIs(""));
        driver.getTitle();

        // Ket hop nhie dieu kien
        explicitWait.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")), ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.or(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")), ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(""))));

        // cho cho 1 element co attribute chua gia tri mong doi ( tương doi )
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""), "", ""));

        // cho cho 1 element co attribute chua gia tri mong doi ( tuyet doi )
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""), "", ""));

        // Cho cho 1 element co attribute khac null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")), ""));

        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")), "", "" ));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")), "", "" ));
        // Cho cho 1 element dc selected thanh cong
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        // Cho cho 1 elemtn dc selected roi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.cssSelector("")), true));

        // Cho cho 1 element bien mat (ko hien thi tren UI)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

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
