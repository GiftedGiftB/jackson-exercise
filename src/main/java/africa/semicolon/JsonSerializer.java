package africa;

import africa.semicolon.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSerializer {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static String serialize(Person person) {
        try{
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Person deserialize(String json) {
        try{
            Person person = mapper.readValue(json,Person.class);
            return person;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
}
