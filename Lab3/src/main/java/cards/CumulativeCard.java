package cards;

import cardtype.OwnerType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CumulativeCard extends Card {
    private int balance;
    private int travelCoast;


    public CumulativeCard(UUID uniqueID, int balance, int travelCoast) {
        super(uniqueID, OwnerType.STANDARD);
        this.balance = balance;
        this.travelCoast = travelCoast;
    }


    public void replenishment(int quantityTravel) {
        balance += quantityTravel;
    }

    public boolean withdraw() {
        if (balance >= travelCoast) {
            balance -= travelCoast;
            return true;
        }
        return false;
    }

    public boolean verify() {
        return withdraw();
    }

    @Override
    public String toString() {
        return "Card type: cumulative card\n" +
                "Balance: " + balance + "\n";
    }
}
