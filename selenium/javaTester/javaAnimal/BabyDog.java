package javaTester.javaAnimal;

public class BabyDog extends Dog{
    int numbberAge;
    String name;
    public BabyDog(int numbberAge, String name) {
        this.numbberAge = numbberAge;
        this.name = name;
    }

    public BabyDog() {

    }

    public void display(){
        System.out.println("Baby Dog is: " + name + numbberAge);
    }
    void voice(){
        super.voice();
        System.out.println("I am voice child");
    }
    public static void main(String[] args){
        BabyDog dog = new BabyDog();
        dog.voice();
        dog.eat();
        BabyDog doge = new BabyDog(2, "Cun");
        doge.display();
    }
}
