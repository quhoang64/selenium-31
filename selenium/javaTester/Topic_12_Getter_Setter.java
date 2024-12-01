package javaTester;

public class Topic_12_Getter_Setter {
    private String personName;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 10 || age > 60){
            throw new IllegalArgumentException("age must be between 10 and 60");
        }else {
            this.age = age;
        }
    }

    public void setPersonName(String personName) {
        if(personName == null || personName.isEmpty()){
            throw new IllegalArgumentException("personName cannot be null");
        }
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }



}
