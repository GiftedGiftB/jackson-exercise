package africa;

import africa.semicolon.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonSerializerTest {

    @Test
    void testCanSerializeData(){
        Person person = new Person();
        person.setFirstName("john");
        person.setLastName("Smith");
        person.setAge(25);
        String json = africa.JsonSerializer.serialize(person);
        String expected = "{\"firstName\":\"john\",\"lastName\":\"Smith\",\"age\":25}";
        assertEquals(expected,json);
    }
    @Test
    void testCanDeserializeData(){
        String json = "{\"firstName\":\"jane\",\"lastName\":\"Smith\",\"age\":15}";
        Person person = africa.JsonSerializer.deserialize(json);
        assertNotNull(person);
        assertEquals("jane",person.getFirstName());
        assertEquals("Smith",person.getLastName());
        assertEquals(15,person.getAge());
    }
}
