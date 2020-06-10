
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class StringCheckerTest {

    @Test
    public void testFindAverage() {
        StringChecker sc = new StringChecker();
        String[] input = {"123", "1234", "12345"};
        int expResult = 4;
        int actResult = sc.findAverage(input);
        assertEquals(expResult, actResult);
    }

    @Test
    public void testFindLessThanAverage() {
        StringChecker sc = new StringChecker();
        String[] input = {"123", "1234", "12345"};
        String[] expResult = {"123"};
        String[] actResult = sc.findLessThanAverage(input);
        assertArrayEquals(expResult, actResult);
    }

    @Test
    public void calculateFloat() {
        double a = 1.1;
        double b = 1.1;
        System.out.println("a+b = " + (a + b));
        a = 1.1f;
        b = 1.2f;
        System.out.println("a+b = " + (a + b));
        assert true;
    }
    @Test
    public void calculateInteger() {
        Integer a = 150;
        Integer b = 150;
        System.out.println("a+b == " + (a == b));
        a = -20;
        b = -20;
        System.out.println("a+b == " + (a == b));
        assert true;
    }
}
