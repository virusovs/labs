package passengers;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import typepassenger.PoliceTypePassenger;


@Setter
public class Policeman extends Human {
    private PoliceTypePassenger policeTypePassenger;

    public Policeman(String firstName, String lastName, int age, PoliceTypePassenger policeTypePassenger) {
        super(firstName, lastName, age);
        this.policeTypePassenger = policeTypePassenger;
    }


}
