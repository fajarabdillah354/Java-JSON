package fajar.belajar.JSON;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeserializationJsonTest {

    /** Deserialization Feature
     * Jackson memiliki fitur yang bisa di aktifkan atau di nonaktifkan untuk proses deserialization (membaca JSON menjadi Java Object)
     * Ada banyak sekali fitur yang terdapat di Jackson Deserialization, kita bisa lihat di link berikut :
     * https://github.com/FasterXML/jackson-databind/wiki/Deserialization-Features
     */

    @Test
    @SneakyThrows
    void testDeserialization() {

        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)//menonaktifkan jika ada properti yang tidak terdaftar dalam class
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);//menerima single value pada data java Object seperti List<>
        String json = """
                {"firstNAME" : "fajar abdillah", "LASTname" : "ahmad", "grade" : 1, "age" : 23, "hobbies" : "Coding"}
                
                """;
        Student student = mapper.readValue(json, Student.class);

        Assertions.assertEquals("fajar abdillah", student.getFirstName());
        Assertions.assertEquals("ahmad", student.getLastName());
        Assertions.assertEquals(1, student.getGrade());
    }
}
