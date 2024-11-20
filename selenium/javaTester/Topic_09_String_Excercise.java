package javaTester;

import org.testng.annotations.Test;

import java.util.*;

public class Topic_09_String_Excercise {
    String courseName = "Automation Testing Advance";
    @Test
    public void TC_01_test() {
        char[] courseNameArray = courseName.toCharArray();
        int count = 0;
        for (char character : courseNameArray) {
            if(character <= 'Z' && character >= 'A') {
                count++;
            }
        }
        System.out.println("Sum of uppercase = "   + count);

    }

    @Test
    public void TC_02_test() {
        char[] courseNameArr = courseName.toCharArray();
        int count = 0;
        for (char character : courseNameArr){
            if(character == 'a'){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void TC_03_test() {
        String subStringCourse = courseName.substring(5);
        System.out.println(subStringCourse);
        System.out.println(this.courseName.contains("Testing"));
    }

    @Test
    public void TC_04_test() {
        char[] courseNameArr = courseName.toCharArray();

        Collections.reverse(Arrays.asList(courseNameArr));
        for (char character : courseNameArr) {
            System.out.println(character);
        }
        //////////// cac ham thuong su dung / tham khao cach dung ham thoi nhe
        System.out.println(this.courseName.contains("Testing"));
        System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi: " + courseNameArr.equals(courseName));
//      System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi: " + courseNameArr.equalsIgnoreCase("courseName"));
//      System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi: " + courseNameArr.startsWith("courseName"));
//      System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi: " + courseNameArr.endsWith("courseName"));
        // ham split
        String result = "View 80 of 132 product";
        String results[] = result.split(" ");
        System.out.println(results[1]);
        // Ham replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);

        // Ham trim
        String helloWorld = " \n   \t  Hello World";
        System.out.println(helloWorld.trim());
    }


}
