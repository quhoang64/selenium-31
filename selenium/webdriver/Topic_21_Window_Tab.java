package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Window_Tab {
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
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();

        switchToWindowByTitle("Google");

        driver.findElement(By.xpath("//textarea[@title='Tìm kiếm']")).sendKeys("usd to vnd");
        sleepInSeconds(2);

        switchToWindowByTitle("Selenium WebDriver");
        sleepInSeconds(2);

        driver.findElement(By.xpath("//a[text() = 'FACEBOOK']")).click();
        switchToWindowByTitle("Facebook – log in or sign up");
        sleepInSeconds(2);

        closedAllWindows(parentID);
        sleepInSeconds(3);
    }

    @Test
    public void TC_02_Kyna_English() {
        driver.get("https://adult.kynaenglish.com/hoc-tieng-anh-cho-nguoi-di-lam?hasMessengerChat=true&affiliate_id=541195&utm_source=google&utm_medium=cpc&utm_campaign=M_GG_KEA_Brand_Kynavn_V0&gad_source=1&gclid=Cj0KCQjwsc24BhDPARIsAFXqAB3AD03sl-aUQvughAqmo6d2S0capdjvvngGAuABCsFoqTQvD5672DMaAiiYEALw_wcB");
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[@class='social']//a[@href='https://www.facebook.com/Kynaenglish1kem1']")).click();
        sleepInSeconds(2);
        switchToWindowByTitle("Kyna English 1 kèm 1 | Ho Chi Minh City | Facebook");
        sleepInSeconds(2);
        driver.findElement(By.xpath("//label[@aria-label = 'Email address or phone number']//input")).sendKeys("09223214434");

        switchToWindowByTitle("KYNA ENGLISH ADULT - HỌC TIẾNG ANH CHO NGƯỜI ĐI LÀM");
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("p.address")).getText(), "Địa chỉ ĐKKD: Tầng 1, Tòa nhà Packsimex, 52 Đông Du, Phường Bến Nghé, Quận 1, TP Hồ Chí Minh");
        driver.findElement(By.xpath("//div[@class='social']//a[@href='https://www.youtube.com/channel/UCx_EdsKTjLIE01DBAcmjEIQ']")).click();
        sleepInSeconds(2);

        switchToWindowByTitle("KYNA ENGLISH ADULT - HỌC TIẾNG ANH CHO NGƯỜI ĐI LÀM");
        sleepInSeconds(2);

        closedAllWindows(parentID);

    }

    @Test
    public void TC_03_Mantech() {
        driver.get("http://live.techpanda.org/");
        String parentID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("li.nav-1 a.level0 ")).click();
        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/ul/li/a[text() = 'Add to Compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Sony Xperia has been added to comparison list.");
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/ul/li/a[text() = 'Add to Compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSeconds(3);
        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.cssSelector("div h1")).getText(), "COMPARE PRODUCTS");

        switchToWindowByTitle("Mobile");
        driver.findElement(By.cssSelector("input#search")).sendKeys("iphone 15");
        sleepInSeconds(3);

        closedAllWindows(parentID);
    }

    @Test
    public void TC_04_Handle_Window_SeleniumV4(){
        driver.get("https://adult.kynaenglish.com/hoc-tieng-anh-cho-nguoi-di-lam?hasMessengerChat=true&affiliate_id=541195&utm_source=google&utm_medium=cpc&utm_campaign=M_GG_KEA_Brand_Kynavn_V0&gad_source=1&gclid=Cj0KCQjwsc24BhDPARIsAFXqAB3AD03sl-aUQvughAqmo6d2S0capdjvvngGAuABCsFoqTQvD5672DMaAiiYEALw_wcB");

        driver.switchTo().newWindow(WindowType.TAB).get("https://kynaenglish.vn");
        driver.findElement(By.cssSelector("div.text-center a.homepage_btn_cta__Ic2KN")).click();

        switchToWindowByTitle("KYNA ENGLISH ADULT - HỌC TIẾNG ANH CHO NGƯỜI ĐI LÀM");
        driver.findElement(By.cssSelector("div.left input.phone")).sendKeys("123");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.facebook.com/Kynaenglish1kem1");
        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("quanghoang@gmail.com");
        sleepInSeconds(2);

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

    public void switchToWindowByID(String windowID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if(!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle){
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lap duệt qua Set ID o tren
        for (String id : allIDs) {
            // Cho switch vao tung ID truoc
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closedAllWindows(String ParentID){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if(!id.equals(ParentID)) {
                driver.switchTo().window(id);
                driver.close();
            }

        }
        driver.switchTo().window(ParentID);
    }
}
