package javaTester;

public class Topic_10_Non_Access_Modifier {

    // Static: Variable/ Method
    // có the override duoc
    static String BROWSER = "chrome";

    // non-static
    String serverName = "Develop";

    // k cho pheép ghi de/ override
    // final varriable
    final String colorCar = "red";

    public static void main(String[] args) {
        Topic_10_Non_Access_Modifier server = new Topic_10_Non_Access_Modifier();
        System.out.println(server.serverName);
        server.clickToElement("Button");
        System.out.println(BROWSER);
        sendKeyToElemennt("Button");
        System.out.println(server.colorCar);
    }

    public void clickToElement(String elementName){
        System.out.println(elementName);
    }

    public static void sendKeyToElemennt(String elementName){
        System.out.println(elementName);
    }

    // final method
    // ko cho phep ghi de o class khac cung packked
    public final void setCarName(String carName){

    }
}
