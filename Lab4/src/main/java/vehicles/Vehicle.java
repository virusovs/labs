package vehicles;

import exceptions.NoFreePlaceException;
import exceptions.NotFoundPassengerException;
import passengers.Human;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    protected String name;
    protected int passengerCapacity;
    protected List<T> passengers = new ArrayList<>();


    public Vehicle(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;

    }

    public void download(T passenger) throws NoFreePlaceException {
        if (passengers.size() == passengerCapacity)
            throw new NoFreePlaceException("No free places " + passenger.getLastName());
        else
            passengers.add(passenger);

    }

    public void unload(T passenger) throws NotFoundPassengerException {
        if (!passengers.contains(passenger)) throw new NotFoundPassengerException("Passenger " + passenger.getLastName()
                + " not found in the Car");
    }

    public int getCountOfPassengers() {
        return passengers.size();
    }
}

