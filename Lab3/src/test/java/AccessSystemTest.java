import cards.CumulativeCard;
import cards.SeasonCard;
import cards.TemporaryCard;
import cardtype.IntervalType;
import cardtype.OwnerType;
import cardtype.TravelPassType;
import control.AccessSystem;
import control.Pass;
import org.junit.*;

import static org.junit.Assert.*;


public class AccessSystemTest {

    private AccessSystem accessSystem;

    @Before
    public void init() {
        addCardsTurnstileSystem();
    }

    @After
    public void unload() {
        accessSystem.deleteInstance();
    }

    @Test
    public void testPasses() {
        for (Pass pass : accessSystem.passes) {
            System.out.println(pass.toString());
        }

    }

    @Test
    public void testCountAttempt() {
        assertEquals(6, accessSystem.countAttempts());
    }

    @Test
    public void testCountPass() {
        assertEquals(5, accessSystem.countPasses());
        assertNotEquals(6, accessSystem.countPasses());
        assertNotEquals("*", accessSystem.countPasses());
        assertNotEquals(0, accessSystem.countPasses());
    }

    @Test
    public void testCountDeny() {
        assertEquals(1, accessSystem.countDeny());
    }

    @Test
    public void testCountAttemptCumulativeCard() {
        assertEquals(4, accessSystem.countAttemptCumulativeCard());
        assertNotEquals(3, accessSystem.countAttemptCumulativeCard());
    }

    @Test
    public void testCountPassCumulativeCard() {
        assertEquals(3, accessSystem.countPassCumulativeCard());
        assertNotEquals(2, accessSystem.countPassCumulativeCard());
    }

    @Test
    public void testCountDenyCumulativeCard() {
        assertEquals(1, accessSystem.countDenyCumulativeCard());
        assertNotEquals(0, accessSystem.countDenyCumulativeCard());
    }

    @Test
    public void testCountAttemptSeasonCard() {
        assertEquals(1, accessSystem.countAttemptSeasonCard("SCHOOL", "FOUR"));
        assertNotEquals(3, accessSystem.countAttemptSeasonCard("SCHOOL", "FOUR"));
    }

    @Test
    public void testCountPassSeasonCard() {
        assertEquals(1, accessSystem.countPassSeasonCard("SCHOOL", "FOUR"));
        assertNotEquals(3, accessSystem.countPassSeasonCard("SCHOOL", "FOUR"));
    }

    @Test
    public void testCountDenySeasonCard() {
        assertEquals(0, accessSystem.countDenySeasonCard("SCHOOL", "FOUR"));
        assertNotEquals(3, accessSystem.countDenySeasonCard("SCHOOL", "FOUR"));
    }

    @Test
    public void testCountAttemptTemporaryCard() {
        assertEquals(0, accessSystem.countAttemptTemporaryCard("STANDARD", "WEEK"));
        assertEquals(1, accessSystem.countAttemptTemporaryCard("SCHOOL", "MONTH"));
    }

    @Test
    public void testCountPassTemporaryCard() {
        assertEquals(0, accessSystem.countPassTemporaryCard("STANDARD", "WEEK"));
        assertEquals(1, accessSystem.countPassTemporaryCard("SCHOOL", "MONTH"));
    }

    @Test
    public void testGetCountOfFailsByTemporaryCard() {
        assertEquals(0, accessSystem.countDenyTemporaryCard("STANDARD", "WEEK"));
        assertEquals(0, accessSystem.countDenyTemporaryCard("SCHOOL", "MONTH"));
    }

    public void addCardsTurnstileSystem() {
        accessSystem = AccessSystem.getInstance();
        accessSystem.createCard(7);
        accessSystem.createCard(44);
        accessSystem.createCard(OwnerType.SCHOOL, TravelPassType.FOUR);
        accessSystem.createCard(OwnerType.STUDENT, TravelPassType.TEN);
        accessSystem.createCard(OwnerType.SCHOOL, IntervalType.MONTH);
        accessSystem.createCard(OwnerType.STANDARD, IntervalType.WEEK);
        accessSystem.createTurnstileSystem();
        accessSystem.createTurnstileSystem();
        accessSystem.createTurnstileSystem();
        accessSystem.createTurnstileSystem();

        accessSystem.turnstileSystem.get(0).acceptPass((CumulativeCard) accessSystem.getCardByIndex(0));
        accessSystem.turnstileSystem.get(0).acceptPass((CumulativeCard) accessSystem.getCardByIndex(0));
        accessSystem.turnstileSystem.get(1).acceptPass((CumulativeCard) accessSystem.getCardByIndex(1));
        accessSystem.turnstileSystem.get(2).acceptPass((CumulativeCard) accessSystem.getCardByIndex(1));
        accessSystem.turnstileSystem.get(3).acceptPass((SeasonCard) accessSystem.getCardByIndex(2));
        accessSystem.turnstileSystem.get(0).acceptPass((TemporaryCard) accessSystem.getCardByIndex(4));
    }

}

