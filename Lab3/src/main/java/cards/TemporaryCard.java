package cards;

import cardtype.IntervalType;
import cardtype.OwnerType;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class TemporaryCard extends Card {

    private IntervalType intervalType;
    private Date finalDate;
    private int hoursInDay = 24;
    private int minutesInHour = 60;
    private int secondsInMinute = 60;
    private int millisecondInSecond = 1000;

    public TemporaryCard(UUID uniqueId, OwnerType ownerType, IntervalType intervalType) {
        super(uniqueId, ownerType);
        this.intervalType = intervalType;
        finalDate = new Date(new Date().getTime() + (long) intervalType.getDaysLeft() * hoursInDay * minutesInHour * secondsInMinute * millisecondInSecond);
    }



    public boolean verify() {
        boolean isVerified = new Date().before(getFinalDate());
        if (!isVerified) block();
        return isVerified;
    }

    @Override
    public String toString() {
        return "Card type: temporary card\n" +
                "Expiration date: " + getFinalDate().toString() + "\n";
    }
}
