package fajar.belajar.JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonToMapTest {


    /** Membaca JSON Object
     * ObjectMapper selain digunakan untuk membuat JSON Object dari Map, bisa juga digunakan untuk melakukan kebalikannya, membaca JSON menjadi Map
     * Kita bisa menggunakan method :
     * readValue(input, typereference), dimana input adalah InputStream, Reader, String, File, dan lain-lain. Dan typereference adalah class untuk Generic
     */

    @Test
    @SneakyThrows
    void testJsonToMap() {
        String json = """
                    {
                      "firstName": "fajar",
                      "email": "faj@gmail.com",
                      "balance": 100000000
                    }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("fajar", map.get("firstName"));// Key, Value
        Assertions.assertEquals(100000000, map.get("balance"));

    }
}
