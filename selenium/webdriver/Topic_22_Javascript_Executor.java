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

public class Topic_22_Javascript_Executor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //Testcase
    @Test
    public void TC_01() {
        executeForBrowser("window.location = 'https://live.techpanda.org/'");
        sleepInSeconds(2);

        String techDomain = (String) executeForBrowser("return document.domain");
        Assert.assertEquals(techDomain, "live.techpanda.org");

        String homePageURL  = (String) executeForBrowser("return document.URL");
        Assert.assertEquals(homePageURL, "https://live.techpanda.org/");

        clickToElementByJS("//a[text() = 'Mobile']");
        clickToElementByJS("//a[text() = 'Samsung Galaxy']/parent::h2/following-sibling::div[@class = 'actions']/button");
        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        clickToElementByJS("//a[text() = 'Customer Service']");

        String customerTitle = (String) executeForBrowser("return document.title");
        Assert.assertEquals(customerTitle, "Customer Service");

        scrollToBottomPage();
        sendkeyToElementByJS("//input[@id= 'newsletter']", "quhoang1231223@gmail.com");
        clickToElementByJS("//button[@title= 'Subscribe']");

        navigateToUrlByJS("https://kynaenglish.vn/");
        sleepInSeconds(2);
        Assert.assertEquals(executeForBrowser("return document.domain"), "kynaenglish.vn");

    }

    @Test
    public void TC_02() {
        driver.get("https://sieuthimaymocthietbi.com/account/register");
        driver.findElement(By.xpath("//button[text() = 'Đăng ký']")).click();
        sleepInSecond(2);
        Assert.assertEquals(getElementValidationMessage("//input[@id = 'lastName']"), "Please fill out this field.");

        driver.findElement(By.xpath("//input[@id = 'lastName']")).sendKeys("automation");
        sleepInSeconds(2);
        driver.findElement(By.xpath("//button[text() = 'Đăng ký']")).click();
        sleepInSecond(2);
        Assert.assertEquals(getElementValidationMessage("//input[@id = 'firstName']"), "Please fill out this field.");


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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}
