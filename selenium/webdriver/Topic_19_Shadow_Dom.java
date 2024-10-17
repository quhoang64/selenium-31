package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_19_Shadow_Dom {
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
    public void TC_01_Shadow_Dom() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadownRootContext = shadowHostElement.getShadowRoot();

        String someText = shadownRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText, "some text");

        WebElement checkboxShadow =  shadownRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());

        List<WebElement> inputShadow = shadownRootContext.findElements(By.cssSelector("input"));
        System.out.println(inputShadow.size());

        //
        WebElement nestedShadowRoot = shadownRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedTextShadowRootContext = nestedShadowRoot.getShadowRoot();
        String nestedTextshadow = nestedTextShadowRootContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.println(nestedTextshadow);
        Assert.assertEquals(nestedTextshadow, "nested text");

    }

    @Test
    public void TC_02_Shadow_Dom_Shopee() {
        driver.get("https://shopee.vn/");
        sleepInSeconds(10);
        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();

        if (!shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).isEmpty() && shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).get(0).isDisplayed()){
            //close popup
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSeconds(2);
        }

        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("Iphone 15 promax");
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();

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
