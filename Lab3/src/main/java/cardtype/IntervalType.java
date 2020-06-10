package cardtype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IntervalType {

    WEEK(7),

    MONTH(30),

    DAY(1);

    private int daysLeft;


}
