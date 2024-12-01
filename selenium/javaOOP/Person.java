package javaOOP;

public class Person {
    private String firstName;

    // Nested class
    public class pupli{
        String name;
    }

    public static void main(String[] args) {
        Person per = new Person();
        // Person la class
        // per la doi tuong/ bien/ instance

        per.firstName = "John";

        Person.pupli pupli = per.new pupli();
        pupli.name = "John";

    }
}
