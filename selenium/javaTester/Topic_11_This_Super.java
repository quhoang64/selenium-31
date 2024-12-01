package javaTester;

public class Topic_11_This_Super extends BaseOOP{
    private int firstNumber;
    private int secondNumber;

    public Topic_11_This_Super() {
        this(5,10);
    }

    public Topic_11_This_Super(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int sum(){
        return firstNumber + secondNumber;
    }

    public void showSumNumber(){
        System.out.println(sum());
    }


    public static void main(String[] args) {
        Topic_11_This_Super topic = new Topic_11_This_Super();
        topic.showSumNumber();
    }
}
