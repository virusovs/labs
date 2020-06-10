package control;

import cards.Card;
import cards.CumulativeCard;
import cards.SeasonCard;
import cards.TemporaryCard;
import cardtype.IntervalType;
import cardtype.OwnerType;
import cardtype.TravelPassType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccessSystem {

    private static AccessSystem instance;
    private List<Card> cards = new ArrayList<>();
    public List<TurnstileSystem> turnstileSystem = new ArrayList<>();
    public List<Pass> passes = new ArrayList<>();
    public int travelCoast = 4;
    private static int turnstileCount;

    public static AccessSystem getInstance() {
        if (instance == null) {
            instance = new AccessSystem();
        }
        return instance;
    }

    public static void deleteInstance() {
        if (instance != null) instance = null;
    }

    public void createTurnstileSystem() {
        turnstileSystem.add(new TurnstileSystem(this, turnstileCount++));
    }

    public void createCard(int balance) {
        cards.add(new CumulativeCard(UUID.randomUUID(), balance, travelCoast));
    }

    public void createCard(OwnerType ownerType, TravelPassType travelPassType) {
        cards.add(new SeasonCard(UUID.randomUUID(), ownerType, travelPassType));
    }

    public void createCard(OwnerType ownerType, IntervalType intervalType) {
        cards.add(new TemporaryCard(UUID.randomUUID(), ownerType, intervalType));
    }

    public Card getCardByUniqueId(UUID uniqueId) {
        for (Card card : cards) {
            if (card.getUniqueId() == uniqueId)
                return card;
        }
        return null;
    }

    public String getCardInfo(UUID uniqueId) {
        Card card = getCardByUniqueId(uniqueId);
        return "Card ID: " + card.getUniqueId() + "\n" +
                "Owner type: " + card.getOwnerType().toString() + "\n" +
                card.toString();
    }

    public void deleteBlockedCard() {
        for (Card card : cards)
            if (card.isBlocked()) cards.remove(card);
    }

    public Card getCardByIndex(int index) {
        return cards.get(index);
    }

    public List<CumulativeCard> getCumulativeCardList() {
        List<CumulativeCard> cumulativeCardList = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof CumulativeCard) cumulativeCardList.add((CumulativeCard) card);
        }
        return null;
    }

    public List<TemporaryCard> getTemporaryCardList() {
        List<TemporaryCard> temporaryCardList = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof TemporaryCard) temporaryCardList.add((TemporaryCard) card);
        }
        return null;
    }

    public List<SeasonCard> getSeasonCardList() {
        List<SeasonCard> seasonCardList = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof SeasonCard) seasonCardList.add((SeasonCard) card);
        }
        return null;
    }

    public int countAttempts() {
        return passes.size();
    }

    public int countPasses() {
        int counter = 0;
        for (Pass pass : passes) {
            if (pass.isPassed()) counter++;
        }
        return counter;
    }

    public int countDeny() {
        return passes.size() - countPasses();
    }

    public int countPassCumulativeCard() {
        int counter = 0;
        for (Pass pass : passes) {
            if (getCardByUniqueId(pass.getCardId()) instanceof CumulativeCard && pass.isPassed()) counter++;
        }
        return counter;
    }

    public int countAttemptCumulativeCard() {
        int counter = 0;
        for (Pass pass : passes) {
            if (getCardByUniqueId(pass.getCardId()) instanceof CumulativeCard) counter++;
        }
        return counter;
    }

    public int countDenyCumulativeCard() {
        return countAttemptCumulativeCard() - countPassCumulativeCard();
    }

    public int countAttemptSeasonCard(String ownType, String trPassType) {
        int counter = 0;
        OwnerType ownerType;
        TravelPassType travelPassType;
        try {
            ownerType = OwnerType.valueOf(ownType.toUpperCase());
            travelPassType = TravelPassType.valueOf(trPassType.toUpperCase());
        } catch (Exception e) {
            return -1;
        }
        for (Pass pass : passes) {
            Card card = getCardByUniqueId(pass.getCardId());
            if (card instanceof SeasonCard) {
                SeasonCard seasonCard = (SeasonCard) card;
                if (seasonCard.getOwnerType() == ownerType
                        && seasonCard.getTravelPassType() == travelPassType) counter++;
            }
        }
        return counter;
    }

    public int countPassSeasonCard(String ownType, String trPassType) {
        int counter = 0;
        OwnerType ownerType;
        TravelPassType travelPassType;
        try {
            ownerType = OwnerType.valueOf(ownType.toUpperCase());
            travelPassType = TravelPassType.valueOf(trPassType.toUpperCase());
        } catch (Exception e) {
            return -1;
        }
        for (Pass pass : passes) {
            Card card = getCardByUniqueId(pass.getCardId());
            if (card instanceof SeasonCard) {
                SeasonCard multiJourneyCard = (SeasonCard) card;
                if (multiJourneyCard.getOwnerType() == ownerType
                        && multiJourneyCard.getTravelPassType() == travelPassType
                        && pass.isPassed()) counter++;
            }
        }
        return counter;
    }

    public int countDenySeasonCard(String ownType, String seasonType) {
        return countAttemptSeasonCard(ownType, seasonType) - countPassSeasonCard(ownType, seasonType);
    }

    public int countAttemptTemporaryCard(String ownType, String interType) {
        int counter = 0;
        OwnerType ownerType;
        IntervalType intervalType;
        try {
            ownerType = OwnerType.valueOf(ownType.toUpperCase());
            intervalType = IntervalType.valueOf(interType.toUpperCase());
        } catch (Exception e) {
            return -1;
        }
        for (Pass pass : passes) {
            Card card = getCardByUniqueId(pass.getCardId());
            if (card instanceof TemporaryCard) {
                TemporaryCard tempCard = (TemporaryCard) card;
                if (card.getOwnerType() == ownerType
                        && tempCard.getIntervalType() == intervalType) counter++;
            }
        }
        return counter;
    }

    public int countPassTemporaryCard(String ownType, String interType) {
        int counter = 0;
        OwnerType ownerType;
        IntervalType intervalType;
        try {
            ownerType = OwnerType.valueOf(ownType.toUpperCase());
            intervalType = IntervalType.valueOf(interType.toUpperCase());
        } catch (Exception e) {
            return -1;
        }
        for (Pass pass : passes) {
            Card card = getCardByUniqueId(pass.getCardId());
            if (card instanceof TemporaryCard) {
                TemporaryCard tempCard = (TemporaryCard) card;
                if (tempCard.getOwnerType() == ownerType
                        && tempCard.getIntervalType() == intervalType
                        && pass.isPassed()) counter++;
            }
        }
        return counter;
    }

    public int countDenyTemporaryCard(String ownType, String interType) {
        return countAttemptTemporaryCard(ownType, interType) - countPassTemporaryCard(ownType, interType);
    }

}
