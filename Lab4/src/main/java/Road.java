import exceptions.NotFoundCarException;
import vehicles.Vehicle;

import java.util.*;

public class Road {

    public List<Vehicle> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle vehicle : carsInRoad) {
            count += vehicle.getCountOfPassengers();
        }
        return count;

    }

    public void addCarToRoad(Vehicle vehicle) {
        carsInRoad.add(vehicle);
    }

    public void removeCarOfRoad(Vehicle vehicle) throws NotFoundCarException {
        if (!carsInRoad.contains(vehicle))
            throw new NotFoundCarException("Car not found");
        else
            carsInRoad.remove(vehicle);
    }
}
