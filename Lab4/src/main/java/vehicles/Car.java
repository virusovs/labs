package vehicles;

import passengers.Human;

public class Car<T extends Human> extends Vehicle<T> {
    public Car(String name,  int passengerCapacity) {
        super(name,passengerCapacity);
    }


}