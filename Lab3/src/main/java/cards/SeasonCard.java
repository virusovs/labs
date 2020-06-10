package cards;

import cardtype.OwnerType;
import cardtype.TravelPassType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SeasonCard extends Card {

    private int travelLeft;
    private TravelPassType travelPassType;

    public SeasonCard(UUID uniqueId, OwnerType ownerType, TravelPassType travelPassType) {
        super(uniqueId, ownerType);
        this.travelPassType = travelPassType;
        this.travelLeft = travelPassType.getPassesLeft();
    }


    public boolean verify() {
        boolean isVerified = false;
        if (travelLeft > 0) {
            travelLeft--;
            isVerified = true;
        }
        if (!isVerified) block();
        return isVerified;
    }

    @Override
    public String toString() {
        return "Card type: season card\n" +
                "Travels left: " + getTravelLeft() + "\n";
    }
}

