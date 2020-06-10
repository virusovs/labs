package passengers;



import lombok.Setter;

import typepassenger.FireTypePassenger;

@Setter
public class FireFighter extends Human {
    private FireTypePassenger fireTypePassenger;

    public FireFighter(String firstName, String lastName, int age, FireTypePassenger fireTypePassenger) {
        super(firstName, lastName, age);
        this.fireTypePassenger = fireTypePassenger;
    }
}

