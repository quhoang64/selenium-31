package javaTester.javaAccModFirst;

public class Student {
    private int age;

    public void setAge(int enterAge) {
        if (enterAge > 0){
            this.age = enterAge;
        }else {
            System.out.println("enterAge invalid");
        }
    }

    public int getAge(){
        return this.age;
    }
}
