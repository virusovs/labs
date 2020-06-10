package passengers;


import lombok.Getter;


@Getter
public class Human {
    public String firstName;
    public String lastName;
    public int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
