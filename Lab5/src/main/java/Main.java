import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister(new HashMap<>() {{
            put("Fish", 100.0);
            put("Meat", 180.0);
            put("Bread", 17.7);
        }});
        cashRegister.addToCheck("Fish", 2);
        cashRegister.addToCheck("Bread", 4);
        cashRegister.addToCheck("Meat", 5);
        cashRegister.addToCheck("Fish", 2);
        System.out.println(cashRegister.getCheck());
    }
}
