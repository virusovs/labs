package cardtype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TravelPassType {

    FOUR(4),
    TEN(10),
    TWENTY(20);
    private int passesLeft;


}
