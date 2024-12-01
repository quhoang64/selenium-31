package javaTester.javaPractice;

public class Testing extends Topic_01_Practice{
    static String companyName;

    public Testing(){

    }

    public Testing(int a, int b){
        System.out.println(a + b);
    }
    public Testing(String a, String b){
        System.out.println(a);
        System.out.println(b);
    }
    public void display(){
        System.out.println("SSTVN");
    }
//    public void initBrowser(){
//        System.out.println(baseUrl);
//    }

    public static String firstProject(){
        System.out.println("Hàm static");
        return "0";
    }

    public static int sumNumber(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public static float sumNumber(float firstNumber, float secondNumber){
        return firstNumber + secondNumber;
    }
    public static void main(String[] args) {
        Testing test = new Testing();
        Topic_01_Practice pra = new Topic_01_Practice();
        String companyName;
        test = new Testing(5, 6);
        System.out.println(pra.fristNumber);
        companyName = "SSTVN";
        System.out.println(companyName);
        System.out.println(firstProject());
        System.out.println(sumNumber(1, 2));
        System.out.println(sumNumber(2.2f, 3.4f));
        test.display();
        pra.setThirdNumber(10);
        System.out.println(pra.getThirdNumber());
    }


}
