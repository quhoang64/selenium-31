package javaTester;

import org.testng.annotations.Test;

public class Student {
    String studentName;
    int age;

    public Student(String students, int age) {
        this.studentName = students;
        this.age = age;
    }
    public void isDisplay(){
        System.out.println(studentName);
        System.out.println(age);
    }

    @Test
    public void test() {
        Student[] students = new Student[3];
        students[0] = new Student("Quang", 25);
        students[1] = new Student("Lien", 23);
        students[2] = new Student("Haha", 20);

        for (Student student : students) {
            student.isDisplay();
        }
    }
}
