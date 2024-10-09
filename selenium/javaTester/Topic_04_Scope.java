package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class Topic_04_Scope {
    WebDriver driver;
    String homePageUrl;
    String fullName = "Quang Hoang";

    // Pre-condition
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }
    //Testcase
    @Test
    public void TC_01() throws MalformedURLException {
        // Các biến đc khai báo ở trong 1 hàm/ block code -> phạm vi cục bộ (local)
        // Dùng trong cái hàm nó dc khai báo/ block code được sinh ra
        String homePageUrl = "https://www.facebook.com/";

        // Trong 1 hàm nếu có 2 biến cùng tên (global/ local) thì nó sẽ ưu tiên lấy biến local dùng
        // 1 biến local nếu như gọi tới dùng mà chưa đc khởi tạo thì sẽ bị lỗi
        // biến local chưa khởi tạo mà gọi ra dùng nó sẽ báo lỗi ngay (compile code)
        driver.get(homePageUrl);

        // Nếu trong 1 hàm có 2 biến cùng tên (Global/ Local) mà mình muốn lấy biến Global ra để dùng thì dùng từ khoá this
        // Biến Global chưa khởi tạo mà gọi ra dùng thi bảo lỗi ở level (compite code)
        // Level runtime sẽ lỗi
        driver.get(this.homePageUrl);
        //dung để lấy ra Url của màn hình/page hiện tại
        driver.getCurrentUrl();
        // Lấy ra page source HTML/ CSS cua page hiện tại
        // Verify 1 cách tương đối
        driver.getPageSource();
        // Lấy title của page đó
        driver.getTitle();

        // Lấy ra ID của cửa sổ/ tab hien tai
        // Handle Windown/ Tab
        driver.getWindowHandle();
        // lấy toàn bộ cửa sổ thì thêm "s"
        driver.getWindowHandles();

        // Cookies
        driver.manage().getCookies();

        // Get ra những log ở dev tool
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm element (findElement)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Chờ cho page đc load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        // Set trước khi dùng vs thư viện JavascriptExecutor
        // Inject 1 đoạn code JS vào trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        // chạy full màn hình giống F11
        driver.manage().window().fullscreen();
        // chạy full màn hình
        driver.manage().window().maximize();

        // Test GUI
        // Test Responsive
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().window().getSize();

        // set cho broser ở vị trí nào so vs độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu )
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // chuyển hướng/ điều hướng trang web
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // Thao tác vs history của web page (back/forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

        // Alert/ Window (Tab)/ Frame (iFrame)
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys(fullName);
        driver.switchTo().window(driver.getWindowHandle());
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch/ handle frame (iframe)
        // Index/ ID (name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("1233245");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        // từ frame trong đi ra ngoài chứa nó
        driver.switchTo().parentFrame();


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
