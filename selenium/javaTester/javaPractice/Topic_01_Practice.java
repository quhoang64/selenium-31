package javaTester.javaPractice;

public class Topic_01_Practice {
    int fristNumber = 10;
    int secondNumber;
    private int thirdNumber;


    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        if (thirdNumber > 0 ){
            this.thirdNumber = thirdNumber;
        }else {
            System.out.println("third number isn't less than zero");
        }
    }


    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public final void setCarName() {

    }
}
