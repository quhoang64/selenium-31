package javaTester;

public class BaseOOP {

    public static void main(String[] args) {
        Topic_12_Getter_Setter topic = new Topic_12_Getter_Setter();

        // happy case
        topic.setPersonName("automaiton fc");
        System.out.println(topic.getPersonName());

        topic.setAge(-10);
        System.out.println(topic.getAge());

    }

}
