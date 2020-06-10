package control;

import cards.CumulativeCard;
import cards.SeasonCard;
import cards.TemporaryCard;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnstileSystem {

    private AccessSystem accessSystem;
    private int id;


    public boolean acceptPass(CumulativeCard cumulativeCard) {
        boolean passes = cumulativeCard.verify();
        accessSystem.passes.add(new Pass(passes, id, cumulativeCard.getUniqueId(), accessSystem));
        return passes;
    }

    public boolean acceptPass(SeasonCard seasonCard) {
        boolean passes = seasonCard.verify();
        accessSystem.passes.add(new Pass(passes, id, seasonCard.getUniqueId(), accessSystem));
        return passes;
    }

    public boolean acceptPass(TemporaryCard temporaryCard) {
        boolean passes = temporaryCard.verify();
        accessSystem.passes.add(new Pass(passes, id, temporaryCard.getUniqueId(), accessSystem));
        return passes;
    }

}
