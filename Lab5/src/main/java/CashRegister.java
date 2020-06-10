import java.math.BigDecimal;
import java.util.*;

public class CashRegister {
    private Map<String, Integer> goods = new TreeMap<>();
    private Map<String, Double> prices;

    public CashRegister(HashMap<String, Double> prices) {
        this.prices = prices;
    }



    public void addToCheck(String name, int count) {
        if (goods.containsKey(name))
            goods.put(name, count + goods.get(name));
        else
            goods.put(name, count);
    }

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public Double getPrice(String name) {
        return prices.get(name);
    }

    public String getCheck() {
        String result = "";
        double total = 0;
        for (String key : goods.keySet()) {
            result += key + " " + goods.get(key) + "*" + getPrice(key) + " = " + goods.get(key) * getPrice(key) + "\n";
            total += goods.get(key) * getPrice(key);
        }

        return result + "Total amount = " + total;

    }
}
