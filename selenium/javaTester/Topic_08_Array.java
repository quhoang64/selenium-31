package javaTester;

import org.testng.annotations.Test;

public class Topic_08_Array {
    int[] number = {5,8,15,80, 44};

    @Test
    public void TC_01_Find_Max_Number() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (x < number[i]) {
                x = number[i];
            }
        }
        System.out.println("Max number: " + x);
    }

    @Test
    public void TC_02_Total_Number() {
        System.out.println(number[0] + number[number.length - 1]);
    }

    @Test
    public void TC_03_Number_Div_2() {
        for (int i = 0; i < number.length; i++) {
            if(number[i] % 2 == 0){
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void TC_04_Number_Compare_3() {
        for (int i = 0; i < number.length; i++) {
            if(number[i] >= 0 && number[i] <= 10){
                System.out.println(number[i]);
            }
        }
    }
    @Test
    public void TC_05_Number_Avg(){
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }
        System.out.println("Avg number: " + sum);
        System.out.println("Max number: " + sum/ number.length);
    }
}
