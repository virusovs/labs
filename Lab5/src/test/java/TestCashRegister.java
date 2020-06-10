
import java.util.HashMap;

import org.junit.*;

import static org.junit.Assert.*;

public class TestCashRegister {
    CashRegister cashRegister;

    @Before
    public void init() {
        cashRegister = new CashRegister(new HashMap<>() {{
            put("Fish", 100.0);
            put("Meat", 180.0);
            put("Bread", 17.7);
        }});
        cashRegister.addToCheck("Fish", 2);
        cashRegister.addToCheck("Bread", 4);
        cashRegister.addToCheck("Meat", 5);
        cashRegister.addToCheck("Fish", 2);
    }

//    @After
//    public void unload() {
//        cashRegister = null;
//    }

    @Test
    public void testGetGoods() {
        assertEquals("{Bread=4, Fish=4, Meat=5}", cashRegister.getGoods().toString());
    }

    @Test
    public void testGetPrice() {

        assertEquals(Double.valueOf(100.0), cashRegister.getPrice("Fish"));
        assertEquals(Double.valueOf(180.0), cashRegister.getPrice("Meat"));
        assertNotEquals(17.7, cashRegister.getPrice("Meat"));
    }

    @Test
    public void testGetCheck() {
        assertEquals("Bread 4*17.7 = 70.8\n" +
                        "Fish 4*100.0 = 400.0\n" +
                        "Meat 5*180.0 = 900.0\n" +
                        "Total amount = 1370.8",
                cashRegister.getCheck());
    }
}
