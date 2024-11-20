package javaTester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Switch_Case {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_test() {
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
                System.out.println("Co 30 ngay");
                break;
            case 10:
            case 4:
            case 6:
                System.out.println("Co 31 ngay");
                break;
            case 2:
                System.out.println("Co 28 ngay");
                break;

        }
    }
}
