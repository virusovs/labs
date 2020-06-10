import exceptions.NoFreePlaceException;
import exceptions.NotFoundCarException;
import exceptions.NotFoundPassengerException;
import passengers.Human;
import passengers.Policeman;
import typepassenger.PoliceTypePassenger;
import vehicles.Bus;
import vehicles.PoliceCar;
import vehicles.Taxi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTest {
    Road road;


    @Before
    public void setUp() throws Exception {
        road = new Road();
        Taxi taxi = new Taxi("Nissan_Leaf", 4);
        taxi.download(new Human("Andrey", "Ishuk", 33));
        road.addCarToRoad(taxi);
    }

    @Test
    public void testGetCountOfHumans() {
        assertEquals(1, road.getCountOfHumans());
        assertNotEquals(3, road.getCountOfHumans());
    }

    @Test(expected = NotFoundCarException.class)
    public void testRemoveVehicle() throws Exception {
        road.removeCarOfRoad(new Taxi("Nissan_Leaf", 4));
    }

    @Test(expected = NotFoundPassengerException.class)
    public void unloadPassenger() throws Exception {
        Bus bus = new Bus("Mercedes", 32);
        Human human = new Human("Grisha", "Sapognikov", 37);
        bus.unload(human);
    }

    @Test(expected = NoFreePlaceException.class)
    public void testFreePlaces() throws Exception {
        PoliceCar policeCar;
        policeCar = new PoliceCar("Toyota_Prius", 2);
        policeCar.download(new Policeman("Andrey", "Chertushkin", 25, PoliceTypePassenger.PRIVATE));
        policeCar.download(new Policeman("Dima", "Kievskyiy", 29, PoliceTypePassenger.CORPORAL));
        policeCar.download(new Policeman("Grisha", "Pechalnuy", 30, PoliceTypePassenger.PRIVATE));
    }

    @Test
    public void testAddVehicle() {
    }

    @After
    public void tearDown() throws Exception {
        road = null;
    }

}