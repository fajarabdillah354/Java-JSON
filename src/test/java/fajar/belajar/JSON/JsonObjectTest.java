package fajar.belajar.JSON;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class JsonObjectTest {
    @Test
    @SneakyThrows
    void testCreateJsonWithMap() {
        Map<String, Object> person = Map.of(
            "firstname","fajar abdillah",
            "lastname","ahmad",
            "age",23,
            "married",false,
            "hobby" , Map.of(
                    "Renang","renang",
                        "Sepak Bola","sepakbola"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(person);
        System.out.println(value);

    }


    @Test
    void testJsonWithOutputStream() {

        Person person = new Person("fajar", "fajardillah25@gmail.com", 20_000_000);
        ObjectMapper objectMapper = new ObjectMapper();

        Path path = Path.of("ujeh.json");
        try(OutputStream outputStream = Files.newOutputStream(path)) {
            objectMapper.writeValue(outputStream, person);
        }catch (IOException exception){

        }
    }


    @Test
    void testJsonWithFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person("fajar","faj@gmail.com",100_000_000);
        File file = new File("testFileJson.json");
        try {
            objectMapper.writeValue(file, person);
        }catch(Exception exception){
            Assertions.fail(exception);
        }

    }
}
