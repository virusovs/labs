import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PersonTest {
    private File file = null;
    private Person person = null;
    private JSONWorker jsonWorker = null;
    private Person personFromJson = null;

    @Before
    public void setUp() {
        file = new File("D:\\Lab2\\person.json");
        person = new Person("Andrey", "Sadoviy", 1.70, 35, 90.0);
        jsonWorker = new JSONWorker();
        jsonWorker.saveToJSONFile(person, file);
    }

    @Test
    public void PersonIsSerializable() {
        personFromJson = jsonWorker.loadFromJSON(file);
        assertTrue(person.equals(personFromJson));
    }

    @Test
    public void testIsEquals() throws Exception {
        EqualsVerifier.forClass(Person.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();

    }
}
