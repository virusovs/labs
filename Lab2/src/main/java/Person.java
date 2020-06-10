
public class Person {
    private  String name;
    private  String surname;
    private  double height;
    private  int age;
    private  double weight;

    public Person(String name,String surname,double height, int age, double weight) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (Double.compare(person.height, height) != 0) return false;
        if (age != person.age) return false;
        if (Double.compare(person.weight, weight) != 0) return false;
        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(surname, person.surname);
    }

    @Override
    public  int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + age;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
