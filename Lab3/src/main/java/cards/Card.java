package cards;

import cardtype.OwnerType;
import lombok.Getter;

import java.util.UUID;


@Getter
public abstract class Card {

    private UUID uniqueId;
    private OwnerType ownerType;
    private boolean isBlocked;

    public Card(UUID uniqueID, OwnerType ownerType) {
        this.uniqueId = uniqueID;
        this.ownerType = ownerType;
        isBlocked = false;

    }


    public void block() {
        isBlocked = true;
    }


    public abstract boolean verify();

    public abstract String toString();


}
