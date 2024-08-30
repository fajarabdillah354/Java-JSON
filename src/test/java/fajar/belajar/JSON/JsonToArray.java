package fajar.belajar.JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.List;

@Slf4j
public class JsonToArray {

    /** Membuat JSON Array
     * Untuk representasi JSON Array di Java, kita bisa menggunakan tipe data collection, seperti List atau Set misalnya
     * Dan untuk membuat JSON Array dari tipe data collection, kita bisa menggunakan method yang sama seperti membuat JSON Object
     */


    @Test
    @SneakyThrows
    void testJsonToArray() {
        List<String> hobbies = List.of("coding","swimming","fishing");

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(hobbies);

        log.info("{}",value);
    }

    @Test
    @SneakyThrows
    void testReadJsonArray() {

        // Membaca JSON Array
        // Untuk membaca JSON Array, kita juga bisa menggunakan method yang sama seperti membaca JSON Object

        String json = """
                    ["coding","swimming","fishing"]
                """;

        ObjectMapper mapper = new ObjectMapper();
        List<String> list = mapper.readValue(json, new TypeReference<List<String>>() {
        });

        Assertions.assertEquals(List.of("coding","swimming","fishing"), list);
    }
}
