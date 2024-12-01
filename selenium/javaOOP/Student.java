package javaOOP;

public class Student {
    private int maSV;
    private String name;
    private float diemLT;
    private float diemTH;

    public Student(int maSV, String name, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.name = name;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }


    private float getDiemTH() {
        return diemTH;
    }

    private void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }

    private float getDiemLT() {
        return diemLT;
    }

    private void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getMaSV() {
        return maSV;
    }

    private void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    private float showDiemTB(){
//        System.out.println("Diem TB = "+ (diemLT+diemTH*2)/3);
        return (this.diemLT+ this.diemTH*2)/3;
    }
    private void showInforSV(){
        System.out.println(maSV);
        System.out.println(name);
        System.out.println(showDiemTB());
    }

    public static void main(String[] args){
        Student stu = new Student(101231, "John Smith", 8.5f, 7.75f);
        stu.showInforSV();
    }
}
