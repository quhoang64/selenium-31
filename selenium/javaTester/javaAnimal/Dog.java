package javaTester.javaAnimal;

public class Dog extends Animal{
    int firstNumber;
    int secondNumber;


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void sum_Number(){
        System.out.println("Sum Number: " + (firstNumber + secondNumber) + " is correctly");
    }

    void voice(){
        System.out.println("I am voice");
    }
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.voice();
        dog.setFirstNumber(5);
        dog.setSecondNumber(7);
        dog.sum_Number();
    }

}
